package employeeController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Customer;
import forms.CustRegisterForm;
import model.CustomerDAO;
import model.Model;

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
		try {
			custForm = custRegFactory.create(request);
			if (!custForm.isPresent()) {
				return "customerRegister.jsp";
			}
			errors.addAll(custForm.getValidationErrors());
			if (errors.size() != 0) {
				return "customerRegister.jsp";
			}
		} catch (FormBeanException e) {
			e.printStackTrace();
		}
		try {
			Transaction.begin();

			if (customerDAO.match(MatchArg.equalsIgnoreCase("username",
					custForm.getCustUsername().trim()))==null) {
//			if(true){
				Customer customerRecord = new Customer();
				customerRecord.setFirstName(custForm.getFname());
				customerRecord.setLastName(custForm.getLname());
				customerRecord.setAddr_line1(custForm.getCustAddress1());
				customerRecord.setAddr_line2(custForm.getCustAddress2());
				customerRecord.setCity(custForm.getCustCity());
				customerRecord.setCash(Double.parseDouble(custForm
						.getCustCashValue()));
				customerRecord.setZip(Integer.parseInt(custForm.getCustZip()));
				customerRecord.setUsername(custForm.getCustUsername());
				customerRecord.setPassword(custForm.getCustPassword());
				customerRecord.setState(custForm.getCustState());

				customerDAO.create(customerRecord);
				Transaction.commit();
				return "customerRegisterSuccess.jsp";
			} else {
				System.out.println("error");
				errors.add("Email already exist");
				return "customerRegistration.jsp";
			}

		} catch (RollbackException e) {
			e.printStackTrace();
		}finally{
			Transaction.rollback();
		}

		return null;
	}

}
