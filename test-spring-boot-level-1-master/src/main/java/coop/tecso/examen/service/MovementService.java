package coop.tecso.examen.service;

import java.util.List;

import coop.tecso.examen.model.CurrentAccount;
import coop.tecso.examen.model.Movement;

public interface MovementService {
	
	public List<Movement> getMovementsFromAccount (Long id);
	public void createMovement(Movement movement);
	

}
