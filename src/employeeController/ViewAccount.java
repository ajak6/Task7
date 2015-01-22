package employeeController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.Customer;
import databeans.Position;
import databeans.Transaction;
import model.CustomerDAO;
import model.FundDAO;
import model.Fund_Price_HistoryDAO;
import model.Model;
import model.PositionDAO;
import model.TransactionDAO;

public class ViewAccount extends Action {
	private CustomerDAO customerDAO;
	private PositionDAO positionDAO;
	private TransactionDAO transactionDAO;
	private FundDAO fundDAO;
	private Fund_Price_HistoryDAO fundPriceDAO;

	public ViewAccount(Model model) {
		customerDAO = model.getCustomerDAO();
		positionDAO = model.getPositionDAO();
		transactionDAO = model.getTransactionDAO();
		fundDAO = model.getFundDAO();
		fundPriceDAO = model.getFund_Price_HistoryDAO();
	}

	public String getName() {
		return "view_account_e.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {
			Customer customer = (Customer) request.getSession(false)
					.getAttribute("username");
			request.setAttribute("target", customer);
			Position[] positionList = positionDAO.getPositions(customer
					.getCustomer_id());
			request.setAttribute("positionList", positionList);
			Transaction[] tran = transactionDAO.getTransaction(customer
					.getCustomer_id());
			String date = null;
			if (tran.length > 0) {
				for (int i = 0; i < tran.length - 1; i++) {
					if (tran[i + 1].getTransaction_id() > tran[i]
							.getTransaction_id()) {
						date = tran[i + 1].getExecute_date();
					}
				}
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
			Date last = null;
			try {
				last = sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("date", last);
			long[] price = new long[positionList.length];
			for(int i = 0; i < price.length ; i++){
				price[i] = fundPriceDAO.getLastPrice(positionList[i].getFund_id());
			}
			request.setAttribute("price", price);
			return "ViewAccount_e.jsp";
		} catch (RollbackException e) {
			e.printStackTrace();
			return "error.jsp";
		}

	}

}
