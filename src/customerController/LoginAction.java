package customerController;

import javax.servlet.http.HttpServletRequest;

import model.CustomerDAO;
import model.Model;

public class LoginAction extends Action{
	
	private CustomerDAO customerDAO;
	
	public LoginAction(Model model) {
		customerDAO = model.getCustomerDAO();
	}
	
	//Need to modify 
	public String getName() {
		return "";
	}
	
	//Need to modify
	public String perform(HttpServletRequest request) {
		 return "";
	 }

}
