package customerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.Customer;
import databeans.Fund;
import databeans.Position;
import model.CustomerDAO;
import model.FundDAO;
import model.Model;
import model.PositionDAO;

public class ManageFund extends Action {
	private PositionDAO positionDAO;
	private CustomerDAO customerDAO;
	private FundDAO fundDAO;
	
	public ManageFund(Model model){
		positionDAO = model.getPositionDAO();
		customerDAO = model.getCustomerDAO();
		fundDAO = model.getFundDAO();
	}
	public String getName() {
		return "managefund.do";
	}
	
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        try {
			Customer customer  = (Customer) request.getSession(false).getAttribute("customer");
			Position[] positionList = positionDAO.getPositions(customer.getCustomer_id());
			request.setAttribute("positionList", positionList);
	        return "SellFund.jsp";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
	}

}
