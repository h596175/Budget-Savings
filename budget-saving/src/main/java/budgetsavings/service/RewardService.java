package budgetsavings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import budgetsavings.model.Account;
import budgetsavings.model.SavingGoal;
import budgetsavings.repository.AccountRepository;
import budgetsavings.repository.SavingGoalRepository;

@Service
public class RewardService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	SavingGoalRepository savingGoalRepository;
	
	public Account checkSavingGoals(Account account) {
		List<SavingGoal> goals = (List<SavingGoal>) savingGoalRepository.findAll();
		
		
		for(SavingGoal goal : goals) {
			
			if(account.getBalance() >= goal.getGoal() & !goal.isReachedGoal()) {
				account.setBalance(account.getBalance()+100);
				goal.setReachedGoal(true);
			}
		}
		return account;
	}
}
