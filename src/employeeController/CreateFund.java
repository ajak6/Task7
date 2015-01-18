package employeeController;

import java.util.ArrayList;
import java.util.List;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;
import forms.CreateFundForm;
import model.CustomerDAO;
import model.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.EmployeeDAO;
import databeans.Employee;
import formbeans.CreateF;
public class CreateFund extends Action {
	private FormBeanFactory<CreateF> formBeanFactory = FormBeanFactory.getInstance(CreateF.class);
	private EmployeeDAO employeeDAO;
	
	public CreateFund(Model model) {
		employeeDAO = model.getEmployeeDAO();
	}

	public String getName() { return "register.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

        try {
	        CreateF form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
	
	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "register.jsp";
	        }
	
	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "register.jsp";
	        }
	
	        // Create the user bean
	        Fund fund = new Fund();
	        user.setUserName(form.getUserName());
	        user.setFirstName(form.getFirstName());
	        user.setLastName(form.getLastName());
	        user.setPassword(form.getPassword());
        	userDAO.create(user);
        
			// Attach (this copy of) the user bean to the session
	        HttpSession session = request.getSession(false);
	        session.setAttribute("user",user);
	        
			return "manage.do";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "register.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "register.jsp";
        }
    }
}
