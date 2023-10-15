package budgetsavings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import budgetsavings.model.SavingGoal;
import budgetsavings.repository.SavingGoalRepository;

@Service
public class SavingGoalService {

	@Autowired
	private SavingGoalRepository savingGoalRepository;

	public SavingGoal saveGoal(SavingGoal goal) {

		return savingGoalRepository.save(goal);
	}

	public List<SavingGoal> getAllGoals() {
		return (List<SavingGoal>) savingGoalRepository.findAll();
	}

	public SavingGoal getGoal(Long id) {
		
		SavingGoal foundGoal = null;

		try {
			foundGoal = savingGoalRepository.findById(id).get();
		} catch (Exception e) {
			System.out.println(e);
		}
		return foundGoal;

	}
}
