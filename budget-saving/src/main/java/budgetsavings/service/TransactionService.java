package budgetsavings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import budgetsavings.model.Transaction;
import budgetsavings.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public List<Transaction> getAllTransactions() {
		return (List<Transaction>) transactionRepository.findAll();
	}

	public Transaction getTransaction(Long id) {

		Transaction foundTransaction = null;

		try {
			foundTransaction = transactionRepository.findById(id).get();

		} catch (Exception e) {

			System.out.println(e);
		}

		return foundTransaction;
	}

	public Transaction updateTransaction(Transaction transaction, Long id) {

		Transaction foundTransaction = transactionRepository.findById(id).get();

		foundTransaction.setDescription(transaction.getDescription());
		foundTransaction.setDate(transaction.getDate());

		return transactionRepository.save(foundTransaction);
	}
	
}
