package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("username")
public class Employee {
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	private String  employeeName = null;
	private String  Password = "*";
	public boolean checkPassword(String password) {
		return Password.equals((password));
	}
	private String username, firstName, lastName;
	public String  getEmployeeName()       { return employeeName;       }
	//Getter
	public String getUsername() {
		return username;
	}	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	//Setter
	public void setUsername(String s){
		username = s;
	}
	public void setFirstName(String s) {
		firstName = s;
	}
	public void setLastName(String s) {
		lastName = s;
	}
}
