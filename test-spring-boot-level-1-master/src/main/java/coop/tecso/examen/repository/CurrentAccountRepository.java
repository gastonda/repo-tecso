package coop.tecso.examen.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import coop.tecso.examen.model.CurrentAccount;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {
	
	
	

}
