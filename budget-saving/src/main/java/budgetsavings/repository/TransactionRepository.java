package budgetsavings.repository;

import org.springframework.data.repository.CrudRepository;

import budgetsavings.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction,Long> {}
