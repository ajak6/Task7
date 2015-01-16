package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import databeans.Customer;

public class CustomerDAO extends GenericDAO<Customer>{
	public CustomerDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Customer.class, tableName, pool);
	}
	
	//CustomerDAO action starts here
}
