package employeeController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.CustomerDAO;
import model.EmployeeDAO;
import model.Model;

import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Customer;
import formbeans.DepositCheckForm;

public class DepositCheckAction extends Action{
	private FormBeanFactory<DepositCheckForm> formBeanFactory = FormBeanFactory
			.getInstance(DepositCheckForm.class);

	private EmployeeDAO employeeDAO;
	private CustomerDAO customerDAO;

	public DepositCheckAction(Model model) {
		employeeDAO = model.getEmployeeDAO();
	}

	public String getName() {
		return "deposit_check.doe";
	}

	public String perform(HttpServletRequest request) {
		// Set up error list
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		DepositCheckForm form = null;
		request.setAttribute("form", form);

		try {
			form = formBeanFactory.create(request);

			if (!form.isPresent()) {
				return "depositCheck.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "depositCheck.jsp";
			}

		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "depositCheck.jsp";
		}

		try {
			Transaction.begin();
			
			//extract cash balance
			Customer customer = customerDAO.read(form.getCustomer_id());
			Long balance = customer.getCash();
			request.setAttribute("balance", balance);
			
			//deposit check
				balance = balance + form.getAmount();
				customer.setCash(balance);
				customerDAO.update(customer);
				
				Transaction.commit();
				request.setAttribute("message", "Request Check Successfully");
				return "requesetCheckSuccess.jsp";
			
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
