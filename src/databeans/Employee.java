
package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("username")
public class Employee {
<<<<<<< HEAD

=======
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
>>>>>>> b686f3477bead8086d071abd3a6b2dd1191ff9c0
	private String  employeeName = null;
	private String  Password = "*";
	public boolean checkPassword(String password) {
		return Password.equals((password));
	}
	private String username, firstName, lastName;
	private String password; 
	//public String  getEmployeeName()       { return employeeName;       }
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
//>>>>>>> origin/master
