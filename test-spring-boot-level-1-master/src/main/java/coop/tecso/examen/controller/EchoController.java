package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.EchoMessage;
import coop.tecso.examen.model.CurrentAccount;
import coop.tecso.examen.model.Movement;
import coop.tecso.examen.repository.CurrentAccountRepository;
import coop.tecso.examen.repository.MovementRepository;

@RestController
public class EchoController {
	
	@Autowired
	private CurrentAccountRepository currentAccountRepository;
	
	@Autowired 
	private MovementRepository movementRepository;
	
    @PostMapping("/echo")
    public ResponseEntity<?> echo(EchoMessage message) {
    	
    	EchoMessage response = new EchoMessage();
    	response.setMensaje("Mensaje recibido: " + message.getMensaje());
    
    	return new ResponseEntity<EchoMessage>(response, HttpStatus.OK);
    
    }
    
    @GetMapping("/lala")
    public void lala () {
    	
    	List<CurrentAccount> accounts= currentAccountRepository.findAll();
    	List<Movement> movements= new ArrayList();
    	Movement mov= new Movement();
    	mov.setAmount((float)2232.2);
    	mov.setDescription("deded");
    	movements.add(mov);
    	for (CurrentAccount currentAccount : accounts) {
    		currentAccount.setMovements(movements);
			System.out.println(currentAccount.getBalance()+" ---lala...... : "+ currentAccount.getMovements().get(0).getAmount());
			
		}
    	
    }

}
