package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import databeans.Position;

public class PositionDAO extends GenericDAO<Position>{
	public PositionDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Position.class, tableName, pool);
	}
	
	//PositionDAO action starts here
}
