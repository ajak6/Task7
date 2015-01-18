/*package employeeController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.EmployeeDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Employee;
import formbeans.ChangePwdForm;

public class ChangeEpwdAction extends Action {
	private FormBeanFactory<ChangePwdForm> formBeanFactory = FormBeanFactory.getInstance(ChangePwdForm.class);
	
	private EmployeeDAO employeeDAO;

	public ChangeEpwdAction(Model model){
		employeeDAO = model.getEmployeeDAO();
	}

	public String getName() { return "change-pwd.do"; }
    
    public String perform(HttpServletRequest request) {
    	// Set up error list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

        try {
            // Set up user list for nav bar
			request.setAttribute("userList",employeeDAO.getUsers());
	        
	        // Load the form parameters into a form bean
	        ChangePwdForm form = formBeanFactory.create(request);
	        
	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "change-pwd.jsp";
	        }
	
	        // Check for any validation errors
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "change-pwd.jsp";
	        }
	
	        Employee user = (Employee) request.getSession().getAttribute("user");
	
			// Change the password
	        //employeeDAO.setPassword(user.getUsername(),form.getNewPassword());
	
			request.setAttribute("message","Password changed for "+user.getUsername());
	        return "success.jsp";
        } catch (RollbackException e) {
        	errors.add(e.toString());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.toString());
        	return "error.jsp";
        }
    }
}
=======
package employeeController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.EmployeeDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Employee;
import formbeans.ChangePwdForm;

public class ChangeEpwd extends Action {
	private FormBeanFactory<ChangePwdForm> formBeanFactory = FormBeanFactory.getInstance(ChangePwdForm.class);
	
	private EmployeeDAO employeeDAO;

	public ChangeEpwd(Model model){
		employeeDAO = model.getEmployeeDAO();
	}

	public String getName() { return "change-pwd.do"; }
    
    public String perform(HttpServletRequest request) {
    	// Set up error list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

        try {
            // Set up user list for nav bar
			request.setAttribute("userList",employeeDAO.getUsers());
	        
	        // Load the form parameters into a form bean
	        ChangePwdForm form = formBeanFactory.create(request);
	        
	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "change-pwd.jsp";
	        }
	
	        // Check for any validation errors
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "change-pwd.jsp";
	        }
	
	        Employee user = (Employee) request.getSession().getAttribute("user");
	
			// Change the password
	        employeeDAO.setPassword(user.getEmployeeName(),form.getNewPassword());
	
			request.setAttribute("message","Password changed for "+user.getEmployeeName());
	        return "success.jsp";
        } catch (RollbackException e) {
        	errors.add(e.toString());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.toString());
        	return "error.jsp";
        }
    }
}
>>>>>>> b686f3477bead8086d071abd3a6b2dd1191ff9c0:src/employeeController/ChangeEpwd.java
*/