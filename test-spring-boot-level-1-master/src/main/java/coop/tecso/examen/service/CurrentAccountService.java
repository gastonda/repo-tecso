package coop.tecso.examen.service;

import java.util.List;

import org.hibernate.JDBCException;

import coop.tecso.examen.model.CurrentAccount;

public interface CurrentAccountService {
	
	public void updateAccount (CurrentAccount currentAccount)  throws JDBCException;
	public void deleteAccount (CurrentAccount currentAccount) throws JDBCException;
	public List<CurrentAccount> getAccounts();
	public CurrentAccount findAccountById(Long id);

}
