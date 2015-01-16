package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import databeans.Employee;

public class EmployeeDAO extends GenericDAO<Employee>{
	public EmployeeDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Employee.class, tableName, pool);
	}
	
	//EmployeeDAO action starts here
}
