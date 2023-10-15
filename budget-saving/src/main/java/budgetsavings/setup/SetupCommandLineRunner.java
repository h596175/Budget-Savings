package budgetsavings.setup;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import budgetsavings.model.Account;
import budgetsavings.model.Transaction;
import budgetsavings.repository.AccountRepository;
import budgetsavings.repository.TransactionRepository;

@Component
public class SetupCommandLineRunner implements CommandLineRunner {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public void run(String... args) throws Exception {

		CreateAccountsFromData();
		CreateTransactionsFromData();

	}

	private void CreateAccountsFromData() {
		ObjectMapper objMap = new ObjectMapper();
		InputStream inputStreamAccount = TypeReference.class.getResourceAsStream("/data/accounts.json");

		try {
			Map<String, List<Account>> accountData = objMap.readValue(inputStreamAccount,
					new TypeReference<Map<String, List<Account>>>() {
					});
			List<Account> accounts = accountData.get("accounts");
			accounts.forEach(a -> accountRepository.save(a));

			System.out.println("Account initiliazition done!");

		} catch (IOException e) {
			System.out.println("Unable to setup DB properly: " + e.getMessage());
		}
	}

	private void CreateTransactionsFromData() {

		ObjectMapper objMap = new ObjectMapper();
		InputStream inputStreamTransaction = TypeReference.class.getResourceAsStream("/data/transactions.json");

		try {
			Map<String, List<Transaction>> transactionData = objMap.readValue(inputStreamTransaction,
					new TypeReference<Map<String, List<Transaction>>>() {
					});
			List<Transaction> transactions = transactionData.get("transactions");
			transactions.forEach(t -> transactionRepository.save(t));
			System.out.println("Transaction initiliazition done!");
			
			
			
		} catch (IOException e) {
			System.out.println("Unable to setup DB properly: " + e.getMessage());
		}
	}
	
}
