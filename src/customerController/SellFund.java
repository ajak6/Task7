package customerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.Customer;
import databeans.Fund;
import databeans.Transaction;
import model.CustomerDAO;
import model.FundDAO;
import model.Model;
import model.PositionDAO;
import model.TransactionDAO;

public class SellFund extends Action{
	private CustomerDAO customerDAO;
	private TransactionDAO transactionDAO;
	private PositionDAO positionDAO;
	private FundDAO fundDAO;
	
	public SellFund(Model model){
		customerDAO = model.getCustomerDAO();
		transactionDAO = model.getTransactionDAO();
		positionDAO = model.getPositionDAO();
		fundDAO = model.getFundDAO();
	}

	public String getName() {
		return "sellfund.doc";
	}

	public String perform(HttpServletRequest request) {
		try {
			List<String> errors = new ArrayList<String>();
	        request.setAttribute("errors",errors);
	        
	        Customer customer = (Customer) request.getSession(false).getAttribute("customer");
			long sellShare = (Integer) request.getSession(false).getAttribute("sellshare");
			int sellfundID = (Integer) request.getSession(false).getAttribute("fundToSell");
			Fund fundToSell = fundDAO.read(sellfundID);
			if(sellShare <= positionDAO.read(customer.getCustomer_id(),fundToSell.getFund_id()).getShares()){
				Transaction trans = new Transaction();
				trans.setAmount(sellShare);
				trans.setCustomer_id(customer.getCustomer_id());
				trans.setFund_id(fundToSell.getFund_id());
				trans.setTransaction_type("Sell");
				
				transactionDAO.create(trans);
				request.setAttribute("customer", customer);
				return "managefund.doc";
			}else{
				errors.add("Not enough fund to sell!");
				return "error.jsp";
			}
			
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error.jsp";
		}
		
		
		
		
		
		
	}
	
}
