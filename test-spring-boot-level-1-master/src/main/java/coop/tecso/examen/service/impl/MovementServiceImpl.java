package coop.tecso.examen.service.impl;

import java.util.List;

import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import coop.tecso.examen.model.Movement;
import coop.tecso.examen.repository.MovementRepository;
import coop.tecso.examen.service.MovementService;

@Service
public class MovementServiceImpl implements MovementService {

	final static Logger logger = Logger.getLogger(MovementServiceImpl.class);
	
	@Autowired
	MovementRepository movementRepository;
	
	@Override
	public List<Movement> getMovementsFromAccount(Long id){
		return movementRepository.findMovementByAccount(id);
		
	}

	@Override
	public void createMovement(Movement movement) throws JDBCException {
		movementRepository.saveAndFlush(movement);
	}



}

