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
