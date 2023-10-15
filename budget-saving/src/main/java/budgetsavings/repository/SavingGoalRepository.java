package budgetsavings.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import budgetsavings.model.Account;
import budgetsavings.model.SavingGoal;

public interface SavingGoalRepository extends CrudRepository<SavingGoal,Long>{

	List<SavingGoal> findByAccount(Account account);
}
