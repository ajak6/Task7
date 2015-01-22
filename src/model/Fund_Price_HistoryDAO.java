package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.Fund_Price_History;

public class Fund_Price_HistoryDAO extends GenericDAO<Fund_Price_History>{
	public Fund_Price_HistoryDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(Fund_Price_History.class, tableName, pool);
	}

	public long getLastPrice(int fund_id) throws RollbackException{
		Fund_Price_History[] fundPrice = match(MatchArg.equals("fund_id", fund_id));
		long result = 0;
		for(int i = 0;i<fundPrice.length-1;i++){
			if(fundPrice[i+1].getFund_id()>fundPrice[i].getFund_id()){
				result = fundPrice[i+1].getPrice();
			}
		}
		return result;
	}

}
