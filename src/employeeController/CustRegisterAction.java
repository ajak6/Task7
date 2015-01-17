package employeeController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.CustomerDAO;
import model.Model;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Customer;
import formbeans.CustRegisterForm;

public class CustRegisterAction extends Action {
	CustomerDAO customerDAO;
	FormBeanFactory<CustRegisterForm> custRegFactory = FormBeanFactory
			.getInstance(CustRegisterForm.class);

	CustRegisterAction(Model model) {
		customerDAO = model.getCustomerDAO();
	}

	@Override
	public String getName() {
		return "custRegistration.doe";
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		CustRegisterForm custForm = null;
		request.setAttribute("form", custForm);
		request.setAttribute("errors", errors);
		try {
			custForm = custRegFactory.create(request);
			if (!custForm.isPresent()) {
				return "customerRegister.jsp";
			}
			System.out.println("request parameter "
					+ request.getParameter("custCity"));

			errors.addAll(custForm.getValidationErrors());
			System.out.println(errors.toString());
			if (errors.size() != 0) {
				return "customerRegister.jsp";
			}
		} catch (FormBeanException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(customerDAO.match(MatchArg.equalsIgnoreCase(
					"username", custForm.getCustUsername().trim())));

			Transaction.begin();
			if (customerDAO.match(MatchArg.equalsIgnoreCase("username",
					custForm.getCustUsername())).length == 0) {
				// if(true){
				Customer customerRecord = new Customer();
				customerRecord.setFirstName(custForm.getCustFirstName());
				customerRecord.setLastName(custForm.getCustLastName());
				customerRecord.setAddr_line1(custForm.getCustAddress1());
				customerRecord.setAddr_line2(custForm.getCustAddress2());
				customerRecord.setCity(custForm.getCustCity());
				customerRecord.setCash(Long.parseLong(custForm
						.getCustCashValue()));
				customerRecord.setZip(Integer.parseInt(custForm.getCustZip()));
				customerRecord.setUsername(custForm.getCustUsername());
				customerRecord.setPassword(custForm.getCustPassword());
				customerRecord.setState(custForm.getCustState());
				customerDAO.createAutoIncrement(customerRecord);

				Transaction.commit();
				request.setAttribute("message", "Customer Added Successfully");
				return "custRegisterSuccess.jsp";
			} else {
				System.out.println("error");
				errors.add("Email already exist");
				return "customerRegister.jsp";
			}

		} catch (RollbackException e) {
			e.printStackTrace();
		} finally {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
		}

		return null;
	}

}
