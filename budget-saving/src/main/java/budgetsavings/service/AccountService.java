package budgetsavings.service;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import budgetsavings.model.Account;
import budgetsavings.model.Transaction;
import budgetsavings.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account deleteAccount(String id) {

		Account foundAccount = accountRepository.findById(id).get();

		if (foundAccount == null) {
			return foundAccount;
		}

		accountRepository.delete(foundAccount);
		return foundAccount;
	}

	public Account updateAccount(Account account, String id) {

		Account foundAccount = accountRepository.findById(id).get();

		foundAccount.setBalance(account.getBalance());
		
		if (!account.getTransactions().isEmpty()) {
			
			Set<Transaction> currentTransactions = foundAccount.getTransactions();
			Set<Transaction> newTransactions = account.getTransactions();

			newTransactions.forEach(t -> t.setAccount(foundAccount));
			currentTransactions.addAll(newTransactions);
			foundAccount.setTransactions(currentTransactions);
		}

		return accountRepository.save(foundAccount);
	}

	public List<Account> getAllAccounts() {
		return (List<Account>) accountRepository.findAll();
	}

	public Account getAccount(String id) {

		Account foundAccount = null;

		try {
			foundAccount = accountRepository.findById(id).get();
		} catch (Exception e) {
			System.out.println(e);
		}

		return foundAccount;
	}
	
}
