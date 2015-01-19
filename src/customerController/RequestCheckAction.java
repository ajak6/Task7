package customerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Customer;
import formbeans.CustRegisterForm;
import formbeans.RequestCheckForm;
import model.CustomerDAO;
import model.Model;

public class RequestCheckAction extends Action {
	private FormBeanFactory<RequestCheckForm> formBeanFactory = FormBeanFactory
			.getInstance(RequestCheckForm.class);

	private CustomerDAO customerDAO;

	public RequestCheckAction(Model model) {
		customerDAO = model.getCustomerDAO();
	}

	public String getName() {
		return "requestCheck.doc";
	}

	public String perform(HttpServletRequest request) {
		// Set up error list
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		RequestCheckForm form = null;
		request.setAttribute("form", form);

		try {
			form = formBeanFactory.create(request);

			if (!form.isPresent()) {
				return "requestCheck.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "requestCheck.jsp";
			}

		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "requestCheck.jsp";
		}

		try {
			Transaction.begin();
			
			//display current cash balance
			Customer customer = (Customer) request.getSession(false)
					.getAttribute("customer");		
			Long balance = customerDAO.read(customer.getCustomer_id()).getCash();
			request.setAttribute("balance", balance);
			
			//deduct amount from current balance
			if (balance > 0) {
				balance = balance - form.getAmount();
				customer.setCash(balance);
				customerDAO.update(customer);
				
				Transaction.commit();
				request.setAttribute("message", "Request Check Successfully");
				return "requesetCheckSuccess.jsp";
			} 

			errors.add("The balance is negative.");
			return "requestCheck.jsp";
			
		} catch (RollbackException e) {
			errors.add(e.toString());
			return "error.jsp";
		} finally {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
		}
	}
}
