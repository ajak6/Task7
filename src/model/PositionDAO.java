package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.Position;

public class PositionDAO extends GenericDAO<Position>{
	public PositionDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Position.class, tableName, pool);
	}

	public Position[] getPositions(int customerID) throws RollbackException{
		return match(MatchArg.equals("customer_id", customerID));
	}
}
