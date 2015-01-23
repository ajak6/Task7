package model;

import java.util.Arrays;

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
	
	public Transaction[] getTransactinoList(int customer_id) throws RollbackException{
		Transaction[] list = match(MatchArg.equals("customer_id",customer_id));
		Arrays.sort(list);
		return list;
	}
}
