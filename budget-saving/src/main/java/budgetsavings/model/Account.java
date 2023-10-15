package budgetsavings.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account {

	@Id
	private String id;

	@Column(nullable = false, unique = true)
	private String account_number;

	@Column(nullable = false)
	private String account_type;

	@Column(nullable = false)
	private double balance;

	@Column(nullable = false)
	private String currency;

	@Column(nullable = false)
	private String owner;

	@OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("account")
	private Set<Transaction> transactions;
	
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("account")
	private Set<SavingGoal> savingGoals;

	
	public Account() {
	}

	public Account(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return the saving goals of the account
	 */
	public Set<SavingGoal> getSavingGoals() {
		return savingGoals;
	}
	
	/**
	 * 
	 * @param savingGoals set the saving goals of the account
	 */
	public void setSavingGoals(Set<SavingGoal> savingGoals) {
		this.savingGoals = savingGoals;
	}

	
	/**
	 * 
	 * @return the transactions of the account
	 */
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	
	/**
	 * 
	 * @param transactions set transaction of the account
	 */
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	/**
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return account number
	 */

	public String getAccount_number() {
		return account_number;
	}
	
	/**
	 * 
	 * @param account_number set the account number
	 */

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	/**
	 * 
	 * @return account type
	 */
	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	/**
	 * 
	 * @return account balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * 
	 * @param balance set the account balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * 
	 * @return currency of the account
	 */
	public String getCurrency() {
		return currency;
	}
	
	
	/**
	 * 
	 * @param currency sets the currency of the account
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * 
	 * @return the owner of the account
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * 
	 * @param owner sets the owner of the account
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

}
