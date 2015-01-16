package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import databeans.Transaction;

public class TransactionDAO extends GenericDAO<Transaction>{
	public TransactionDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Transaction.class, tableName, pool);
	}
	
	//TransactionDAO action starts here

}
