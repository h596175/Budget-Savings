package budgetsavings.repository;

import org.springframework.data.repository.CrudRepository; 
import budgetsavings.model.Account;

public interface AccountRepository extends CrudRepository<Account,String> {}

