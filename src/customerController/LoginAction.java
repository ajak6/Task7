package customerController;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Model;
import model.CustomerDAO;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;
import databeans.Customer;
import formbeans.LoginForm;
public class LoginAction extends Action{
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
	private CustomerDAO customerDAO;

	public LoginAction(Model model) {
		customerDAO = model.getCustomerDAO();
	}

	public String getName() { return "login.do"; }
    
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
	    	LoginForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
	        if (!form.isPresent()) {
	            return "login.jsp";
	        }
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "login.jsp";
	        }
	        Customer customer = customerDAO.read(form.getcEmail());
	        
	        if (customer == null) {
	            errors.add("User Name not found");
	            return "login.jsp";
	        }

//	        // Check the password
//	        if (!customer.checkPassword(form.getcPassword())) {
//	            errors.add("Incorrect password");
//	            return "login.jsp";
//	        }
	
	        // Attach (this copy of) the user bean to the session
	        HttpSession session = request.getSession();
	        session.setAttribute("customer",customer);

	        return "manage.do";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}