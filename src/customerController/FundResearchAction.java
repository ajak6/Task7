package customerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.FundDAO;
import model.Fund_Price_HistoryDAO;
import model.Model;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.Fund;
import databeans.Fund_Price_History;

public class FundResearchAction extends Action {
	FundDAO fundDAO;
	Fund_Price_HistoryDAO fundPriceHistoryDAO;

	public FundResearchAction(Model model) {
		fundPriceHistoryDAO = model.getFund_Price_HistoryDAO();
		fundDAO = model.getFundDAO();
	}

	@Override
	public String getName() {
		return "fundResearch.doc";
	}

	@Override
	public String perform(HttpServletRequest request) {
		String search = request.getParameter("search");
		
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		if (search == null){
			return "Research Fund.jsp";
		}
		if (search == null || search.equals("")) {
			errors.add("enter search term");
			return "Research Fund.jsp";
		}
		try {
			Fund fund[] = fundDAO.match(MatchArg.equals("symbol", search));
			if (fund.length == 0) {
				System.out.println("error");
				errors.add("no matching ticker found");
				return "Research Fund.jsp";
			}
			Integer fundID = fund[0].getFund_id();
			System.out.println("fund if found "+fundID);
			Fund_Price_History fundHistory[] = fundPriceHistoryDAO
					.match(MatchArg.equals("fund_id", fundID));
			request.setAttribute("history", fundHistory);
			return "Research Fund.jsp";
		} catch (RollbackException e) {
			e.printStackTrace();
		}

		return null;
	}

}
