package coop.tecso.examen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="current_account")
public class CurrentAccount extends AbstractPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String currency;
	
	private double balance;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "account_id" , referencedColumnName= "id")
    private List<Movement> movements;
	

	
	
	
	
	public String getCurrency() {
		return currency;
	}
	
	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CurrentAccount [currency=" + currency + ", balance=" + balance + ", movements=" + movements + "]";
	}
	
	
	




	

}
