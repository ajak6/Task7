package model;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.RollbackException;

import databeans.Employee;
import databeans.Customer;

public class EmployeeDAO extends GenericDAO<Employee>{
	public EmployeeDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Employee.class, tableName, pool);
	}
	
	//EmployeeDAO action starts here
	public Employee[] getUsers() throws RollbackException {
		Employee[] users = match();
		Arrays.sort(users);  // We want them sorted by last and first names (as per User.compareTo());
		return users;
	}

}
