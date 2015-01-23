package customerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.Customer;
import databeans.Fund;
import databeans.FundInfo;
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
			FundInfo[] fundInfoList = new FundInfo[positionList.length];
			for(int i=0;i<fundInfoList.length;i++){
				fundInfoList[i].setName(fundDAO.read(positionList[i].getFund_id()).getName());
				fundInfoList[i].setShares(positionList[i].getShares());
				fundInfoList[i].setFund_id(positionList[i].getFund_id());
			}
			request.setAttribute("fundInfoList", fundInfoList);
	        return "SellFund.jsp";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
	}

}
