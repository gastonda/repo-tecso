package coop.tecso.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import coop.tecso.examen.model.Movement;

public interface MovementRepository extends JpaRepository< Movement, Long> {
	
	@Query("SELECT m FROM Movement m WHERE m.account_id = ?1 ORDER BY m.date desc")
	public List<Movement> findMovementByAccount(Long id);

}





