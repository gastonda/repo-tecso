package coop.tecso.examen.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.controller.AccountController;
import coop.tecso.examen.model.CurrentAccount;
import coop.tecso.examen.repository.CurrentAccountRepository;
import coop.tecso.examen.repository.MovementRepository;
import coop.tecso.examen.service.CurrentAccountService;

@Service
public class CurrentAccountServiceImpl implements CurrentAccountService {
	
	final static Logger logger = Logger.getLogger(AccountController.class);
	
	@Autowired
	CurrentAccountRepository currentAccountRepository;
	
	@Autowired
	MovementRepository movementRepository;


	@Override
	public void updateAccount(CurrentAccount currentAccount) throws JDBCException {
			currentAccountRepository.save(currentAccount);
	}

	@Override
	public CurrentAccount findAccountById(Long id) {
		return currentAccountRepository.findById(id).get();
	}
	
	@Override
	public List<CurrentAccount> getAccounts() {
		List<CurrentAccount> accounts= new ArrayList();
		try {
			accounts= currentAccountRepository.findAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return accounts;
	}

	@Override
	public void deleteAccount(CurrentAccount currentAccount) throws JDBCException {
			currentAccountRepository.delete(currentAccount);
	}
	
	

}
