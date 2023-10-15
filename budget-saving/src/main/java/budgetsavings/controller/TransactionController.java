package budgetsavings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import budgetsavings.model.Account;
import budgetsavings.model.Transaction;
import budgetsavings.service.AccountService;
import budgetsavings.service.TransactionService;

@RestController
@RequestMapping("/bank")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AccountService accountService;

	@GetMapping("/transactions")
	public ResponseEntity<Object> getAllTransactions() {
		List<Transaction> transactions = transactionService.getAllTransactions();

		if (transactions.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}

	@GetMapping("/transactions/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable("id") Long id) {
		Transaction foundTransaction = transactionService.getTransaction(id);

		if (foundTransaction == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(foundTransaction, HttpStatus.OK);
	}

	@PostMapping("/transactions/{id}")
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction, @PathVariable("id") String id) {

		Account account = accountService.getAccount(id);

		if (account == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		transaction.setAccount(account);

		double updatedBalance = account.getBalance() + transaction.getAmount();
		account.setBalance(updatedBalance);
		accountService.updateAccount(account, id);

		Transaction newTransaction = transactionService.saveTransaction(transaction);

		return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
	}

	@PutMapping("/transactions/{id}")
	public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction, @PathVariable("id") Long id) {
		Transaction updatedTransaction = transactionService.updateTransaction(transaction, id);
		
		return new ResponseEntity<>(updatedTransaction,HttpStatus.OK);
	}
	
}
