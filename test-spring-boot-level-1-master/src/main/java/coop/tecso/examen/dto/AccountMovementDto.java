package coop.tecso.examen.dto;

import java.util.List;

import coop.tecso.examen.model.CurrentAccount;
import coop.tecso.examen.model.Movement;

public class AccountMovementDto {
	
	private CurrentAccount account;
	private List<Movement> movement;
	
	
	public CurrentAccount getAccount() {
		return account;
	}
	
	public List<Movement> getMovement() {
		return movement;
	}
	public void setMovement(List<Movement> movement) {
		this.movement = movement;
	}
	public void setAccount(CurrentAccount account) {
		this.account = account;
	}
	
	
	
	

}
