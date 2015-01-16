package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import databeans.Fund;

public class FundDAO extends GenericDAO<Fund> {
	public FundDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Fund.class, tableName, pool);
	}
	
	//FundDAO action starts here
}
