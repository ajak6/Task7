package customerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.Customer;
import model.CustomerDAO;
import model.Model;

public class TransactionHistoryAction extends Action{
	private CustomerDAO customerDAO;
	
	public TransactionHistoryAction(Model model) {
		customerDAO = model.getCustomerDAO();
	}
	
	public String getName() {
		return "transaction_history.do";
	}
	
	public String perform(HttpServletRequest request) {
    	// Set up error list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try{
        	Customer customer = (Customer) request.getSession(false).getAttribute("customer");
        	Long cash = customerDAO.read(customer.getCustomer_id()).getCash();
			request.setAttribute("cash", cash);

        	return "manage.do";
        	
        } catch (RollbackException e) {
	    	errors.add(e.toString());
	    	return "error.jsp";
		}
	}
}
