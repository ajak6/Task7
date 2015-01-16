package employeeController;

import javax.servlet.http.HttpServletRequest;

import model.EmployeeDAO;
import model.Model;

public class LoginAction extends Action{
private EmployeeDAO employeeDAO;
	
	public LoginAction(Model model) {
		employeeDAO = model.getEmployeeDAO();
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
