package coop.tecso.examen.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.model.CurrentAccount;
import coop.tecso.examen.model.Movement;
import coop.tecso.examen.repository.CurrentAccountRepository;
import coop.tecso.examen.service.CurrentAccountService;
import coop.tecso.examen.service.MovementService;

@RestController
public class AccountController {
	
	private final Logger logger = Logger.getLogger(AccountController.class);
	
	@Autowired
	CurrentAccountService currentAccountService;
	
	@Autowired
	CurrentAccountRepository currentRepository;
	
	@Autowired
	MovementService movementService;
	
	private final double MAX_PESOS= -1000;
	private final double MAX_DOLARES= -300;
	private final double MAX_EUROS= -150;
	
	@PostMapping("/createAccount")
	public ResponseEntity CreateAccount(@RequestBody CurrentAccount account) {
		
		try{
			account.setCreationTimestamp(new Date());
			currentAccountService.updateAccount(account);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error creating account");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("Account created");
		
	}
	
	@GetMapping("/getAccounts")
	public List<CurrentAccount> getAccounts(){
		return currentAccountService.getAccounts();
	}
	
	
	@GetMapping("/deleteAccount")
	public ResponseEntity deleteAccount(Long id ) {
		CurrentAccount currentAccount= currentAccountService.findAccountById(id);
		if(currentAccount.getMovements().size()<1) {
			try {
				currentAccountService.deleteAccount(currentAccount);
				return ResponseEntity.status(HttpStatus.OK).body("Account deleted");
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account cannot be deleted");
			}
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account cannot be deleted");
		}
	}
	
	@PostMapping("/addMovement")
	public ResponseEntity addMovementToAccount(@RequestBody Movement movement) {
		
		
		CurrentAccount ca= currentAccountService.findAccountById(movement.getAccount_id());
		if(ca== null) {
			logger.warn("Could not find account while creating new movement");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account of movement do not exists");
		}
		movement.setAmount(round(movement.getAmount(),2));
		ca.getMovements().add(movement);
		ca.setBalance(ca.getBalance()+ movement.getAmount());
		ca.setModificationTimestamp(new Date());
		if(!isMovementRejected(ca)) {
			
			 try {
				currentAccountService.updateAccount(ca);
			} catch (Exception e) {
				logger.warn("problem updating account : " + e.getMessage());
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
			}
			 return ResponseEntity.status(HttpStatus.OK).body("movement added");
		
			 
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("REJECTED");
		}
		
	
	}
	
	public Boolean isMovementRejected(CurrentAccount ca) {
		boolean rejected=false;
		
		switch(ca.getCurrency()) {
		
		case "PESOS":
			if(ca.getBalance()< MAX_PESOS) {
				rejected= true;
			}
			break;
		case "DOLARES":
			if(ca.getBalance()< MAX_DOLARES) {
				rejected= true;
			}
			break;
		case "EUROS":
			if(ca.getBalance()< MAX_EUROS) {
				rejected=true;
			}
			break;
		}
		
		return rejected;
		
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
		
		
	

}
