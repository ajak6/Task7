package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import databeans.Fund_Price_History;

public class Fund_Price_HistoryDAO extends GenericDAO<Fund_Price_History>{
	public Fund_Price_HistoryDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Fund_Price_History.class, tableName, pool);
	}
	
	//Fund_Price_HistoryDAO action starts here
}
