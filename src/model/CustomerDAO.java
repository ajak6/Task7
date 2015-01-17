package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.Customer;

public class CustomerDAO extends GenericDAO<Customer>{
	public CustomerDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Customer.class, tableName, pool);
	}
	
	//CustomerDAO action starts here
	
	//Return current cash balance
	public long getBalance(int customer_id) throws RollbackException{
		Customer[] list = match(MatchArg.equals("customer_id",customer_id));
		long cash = list[0].getCash();
		return cash;
	}
	
	public void withdrawalCash(int customer_id, long amount) throws RollbackException{
		Customer[] list = match(MatchArg.equals("customer_id",customer_id));
		long cash = list[0].getCash();
		cash = cash - amount;
		return;
	}
}
