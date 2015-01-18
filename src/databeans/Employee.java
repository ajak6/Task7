package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("username")
public class Employee {
	private String username, firstName, lastName;
	// added by amey
	private String password;

	// Getter
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	// Setter
	public void setUsername(String s) {
		username = s;
	}

	public void setFirstName(String s) {
		firstName = s;
	}

	public void setLastName(String s) {
		lastName = s;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
