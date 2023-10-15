package budgetsavings.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import budgetsavings.model.Account;
import budgetsavings.model.SavingGoal;
import budgetsavings.service.AccountService;
import budgetsavings.service.SavingGoalService;

@RestController
@RequestMapping("/bank")
public class SavingGoalController {
	
	@Autowired
	private SavingGoalService savingGoalService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/goals")
	public ResponseEntity<Object> getAllSavingGoals(){
		List<SavingGoal> goals = savingGoalService.getAllGoals();

		if (goals.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(goals, HttpStatus.OK);
	}
	
	@PostMapping("/goals/{id}")
	public ResponseEntity<SavingGoal> createGoal(@RequestBody SavingGoal goal, @PathVariable("id") String id) {

		Account account = accountService.getAccount(id);
		
		if (account == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		Set<SavingGoal> currentGoals = account.getSavingGoals();
		
		goal.setAccount(account);
		currentGoals.add(goal);
		account.setSavingGoals(currentGoals);
		
		accountService.updateAccount(account, id);
		
		SavingGoal newSavingGoal = savingGoalService.saveGoal(goal);

		return new ResponseEntity<>(newSavingGoal, HttpStatus.CREATED);
	}
	
}
