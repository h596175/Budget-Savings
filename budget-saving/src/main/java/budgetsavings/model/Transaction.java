package budgetsavings.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
 
@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private double amount;
	
	@Column(nullable = false)
	private String currency;
	
	@ManyToOne()
	@JoinColumn(name = "account_id")
	@JsonIgnoreProperties("transactions")
	private Account account;
	
	public Transaction(){}
	
	public Transaction(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return associated account
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * 
	 * @param account set the account to be associated with the transaction
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	
	/**
	 * 
	 * @return the id of the transaction
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id set the id of the transaction
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return the date of the transaction
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * 
	 * @param date set the date of the transaction
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * 
	 * @return the description of the transaction
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * @param description set the description of the transaction
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @return the amount of the transaction
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * 
	 * @param amount set the amount of the transaction 
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * 	
	 * @return the currency type of the transaction
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * 
	 * @param currency set the currency type of the transaction
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
