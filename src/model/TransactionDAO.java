package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.Transaction;

public class TransactionDAO extends GenericDAO<Transaction>{
	public TransactionDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Transaction.class, tableName, pool);
	}

	public Transaction[] getTransaction(int customerID) throws RollbackException{
		return match(MatchArg.equals("customer_id", customerID));
	}
	

}
