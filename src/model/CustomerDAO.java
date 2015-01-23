package model;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.Customer;

public class CustomerDAO extends GenericDAO<Customer>{
	public CustomerDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Customer.class, tableName, pool);
	}
	//CustomerDAO action starts here

	public Customer[] getUsers() throws RollbackException {
		Customer[] users = match();
		Arrays.sort(users); 
		return users;
	}
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
	public int getCustomerId(String customerName) throws RollbackException{
		Customer[] users = match(MatchArg.equals("customerName", customerName));
		int userId = users[0].getCustomer_id();
		return userId;
	}
	public void changeBalance(int customer_id, long amount)throws RollbackException{
		Customer[] list = match(MatchArg.equals("customer_id",customer_id));
		long cash = list[0].getCash();
		cash = cash - amount;
		return;
	}
	
	public void changePassword(int customerID, String password) throws RollbackException {
        try {
        	System.out.println("in change pass word method");
        	Transaction.begin();
			Customer dbUser = read(customerID);
			
			if (dbUser == null) {
				throw new RollbackException("User  no longer exists");
			}
			
			dbUser.setPassword(password);
			
			update(dbUser);
			Transaction.commit();
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}

}
