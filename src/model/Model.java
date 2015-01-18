package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;

public class Model {
	private CustomerDAO customerDAO;
	private EmployeeDAO employeeDAO;
	private Fund_Price_HistoryDAO fund_Price_HistoryDAO;
	private FundDAO fundDAO;
	private PositionDAO positionDAO;
	private TransactionDAO transactionDAO;
	
	public Model(ServletConfig config) throws ServletException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL    = config.getInitParameter("jdbcURL");
			
			ConnectionPool pool = new ConnectionPool(jdbcDriver,jdbcURL);
			
			customerDAO  = new CustomerDAO("Customer", pool);
			employeeDAO = new EmployeeDAO("Employee", pool);
			fund_Price_HistoryDAO = new Fund_Price_HistoryDAO("Fund_Price_History", pool);
			fundDAO = new FundDAO("Fund", pool);
			positionDAO = new PositionDAO("Position", pool);
			transactionDAO = new TransactionDAO("Transaction", pool);
			
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
	
	public CustomerDAO getCustomerDAO()  { return customerDAO; }
	public EmployeeDAO getEmployeeDAO()  { return employeeDAO; }
	public Fund_Price_HistoryDAO getFund_Price_HistoryDAO() { return fund_Price_HistoryDAO;}
	public FundDAO getFundDAO() { return fundDAO;}
	public PositionDAO getPositionDAO() { return positionDAO;} 
	public TransactionDAO getTransactionDAO() { return transactionDAO; }
	
	
}
