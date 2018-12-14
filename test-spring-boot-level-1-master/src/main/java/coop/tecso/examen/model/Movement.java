package coop.tecso.examen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movements")
public class Movement extends AbstractPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
	private Date date;
	private String movementType;
    private Long account_id;
	private String description;
	private double amount;
	
	
	
	
	
	
	public Long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMovementType() {
		return movementType;
	}
	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Movement [date=" + date + ", movementType=" + movementType 
				+ ", description=" + description + ", amount=" + amount + "]";
	}
	
	
	
	

}
