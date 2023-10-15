package budgetsavings.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SavingGoal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private double goal;
	
	@Column(nullable = false)
	private boolean reachedGoal = false;
	
	@ManyToOne()
	@JoinColumn(name = "account_id")
	@JsonIgnore
	private Account account;
	
	
	public SavingGoal() {}
	
	public SavingGoal(String name, double goal) {
		this.name = name;
		this.goal = goal;
	}
	
	/**
	 * 
	 * @return the id of the goal
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id set the id of the goal
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return the name of the goal
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name set the name of the goal
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return the sum of the goal
	 */
	public double getGoal() {
		return goal;
	}
	
	/**
	 * 
	 * @param goal set the goal amount
	 */
	public void setGoal(double goal) {
		this.goal = goal;
	}
	
	/**
	 * 
	 * @return the account bound to the saving goal
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * 
	 * @param account set the account to be bound to the saving goal
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isReachedGoal() {
		return reachedGoal;
	}
	
	/**
	 * 
	 * @param reachedGoal
	 */
	public void setReachedGoal(boolean reachedGoal) {
		this.reachedGoal = reachedGoal;
	}
	
	
}
