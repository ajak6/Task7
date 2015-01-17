package customerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Customer;
import formbeans.RequestCheckForm;
import model.CustomerDAO;
import model.Model;

public class RequestCheckAction extends Action{
	private FormBeanFactory<RequestCheckForm> formBeanFactory = FormBeanFactory.getInstance(RequestCheckForm.class);

	private CustomerDAO customerDAO;
	
	public RequestCheckAction(Model model) {
		customerDAO = model.getCustomerDAO();
	}
	
	public String getName() {
		return "request_check.do";
	}
	
	public String perform(HttpServletRequest request) {
    	// Set up error list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try{
        	
	        RequestCheckForm form = formBeanFactory.create(request);
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
        	
        	Customer customer = (Customer) request.getSession(false).getAttribute("customer");
        	request.setAttribute("cash",customerDAO.getBalance(customer.getCustomer_id()));
       	
        	customerDAO.withdrawalCash(customer.getCustomer_id(), form.getAmount());
        	
        	return "manage.do";
        }catch (RollbackException e) {
        	errors.add(e.toString());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "register.jsp";
        }
	 }
}
