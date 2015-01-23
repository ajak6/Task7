package customerController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.Customer;
import databeans.FundInfo;
import databeans.Position;
import databeans.Transaction;
import model.CustomerDAO;
import model.FundDAO;
import model.Fund_Price_HistoryDAO;
import model.Model;
import model.PositionDAO;
import model.TransactionDAO;

public class ViewAccount extends Action{
	private CustomerDAO customerDAO; 
	private PositionDAO positionDAO;
	private TransactionDAO transactionDAO;
	private FundDAO fundDAO;
	private Fund_Price_HistoryDAO fundPriceDAO;
	
	public ViewAccount(Model model){
		customerDAO = model.getCustomerDAO();
		positionDAO = model.getPositionDAO();
		transactionDAO = model.getTransactionDAO();
		fundDAO = model.getFundDAO();
		fundPriceDAO = model.getFund_Price_HistoryDAO();
	}
	
	public String getName() {
		return "view_account_c.doc";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        try {
            Customer customer = (Customer) request.getSession(false).getAttribute("customer");
            request.setAttribute("target", customer);
            Transaction[] tran = transactionDAO.getTransaction(customer.getCustomer_id());
            String date = null;
            if(tran.length>0){
            	for(int i=0;i<tran.length-1;i++){
            		if(tran[i+1].getTransaction_id()>tran[i].getTransaction_id()){
            			date = tran[i+1].getExecute_date();
            		}
            	}
            }
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date last = null;
			try {
				last = sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            request.setAttribute("date", last);
			Position[] positionList = positionDAO.getPositions(customer.getCustomer_id());
			FundInfo[] fundInfoList = new FundInfo[positionList.length];
			for(int i=0;i<fundInfoList.length;i++){
				fundInfoList[i].setName(fundDAO.read(positionList[i].getFund_id()).getName());
				fundInfoList[i].setShares(positionList[i].getShares());
				fundInfoList[i].setFund_id(positionList[i].getFund_id());
				fundInfoList[i].setPrice(fundPriceDAO.getLastPrice(positionList[i].getFund_id()));
			}
			request.setAttribute("fundInfoList", fundInfoList);
			return "ViewAccount_c.jsp";
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error.jsp";
		}
		
	}

}
