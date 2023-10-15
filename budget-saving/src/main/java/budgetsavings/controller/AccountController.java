package budgetsavings.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import budgetsavings.model.Account;
import budgetsavings.model.SavingGoal;
import budgetsavings.model.Transaction;
import budgetsavings.service.AccountService;
import budgetsavings.service.RewardService;

@RestController
@RequestMapping("/bank")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RewardService rewardService;

	@GetMapping("/accounts")
	public ResponseEntity<Object> getAllAccounts() {

		List<Account> accounts = accountService.getAllAccounts();

		if (accounts.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(accounts, HttpStatus.OK);

	}

	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable("id") String id) {

		Account account = accountService.getAccount(id);

		if (account == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	@GetMapping("/accounts/{id}/transactions")
	public ResponseEntity<Set<Transaction>> getAccountTransactions(@PathVariable("id") String id) {
		
		Account account = accountService.getAccount(id);

		if (account == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(account.getTransactions(), HttpStatus.OK);
	}
	
	@GetMapping("/accounts/{id}/goals")
	public ResponseEntity<Set<SavingGoal>> getAccountGoals(@PathVariable("id") String id){
		
		Account account = accountService.getAccount(id);

		if (account == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(account.getSavingGoals(), HttpStatus.OK);
	}
	
	@PostMapping("/accounts")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		
		Account newAccount = accountService.saveAccount(account);
		
		return new ResponseEntity<>(newAccount,HttpStatus.CREATED);
	}
	
	@PostMapping("/accounts/rewards/{id}")
	public ResponseEntity<Account> checkGoals(@PathVariable("id") String id){
		Account foundAccount = accountService.getAccount(id);
		
		if(foundAccount == null) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		foundAccount = rewardService.checkSavingGoals(foundAccount);
		Account updatedAccount = accountService.updateAccount(foundAccount, id);
		
		return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
	}

	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<Account> deleteAccount(@PathVariable("id") String id) {

		Account deletedAccount = accountService.deleteAccount(id);

		return new ResponseEntity<>(deletedAccount, HttpStatus.OK);
	}

	@PutMapping("/accounts/{id}")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable("id") String id) {

		Account updatedAccount = accountService.updateAccount(account, id);

		return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
	}
}
