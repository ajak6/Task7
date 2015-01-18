package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class LoginForm extends FormBean {
	private String cEmail;
	private String eEmail;
	private String cPassword;
	private String ePassword;	
	public String getcEmail() {
		return cEmail;
	}
	public String geteEmail() {
		return eEmail;
	}
	public String getcPassword() {
		return cPassword;
	}
	public String getePassword() {
		return ePassword;
	}
	public void setcEmail(String s) { cEmail = trimAndConvert(s,"<>\"");  }
	public void setcPassword(String s) {cPassword = s.trim();                  }
	public void seteEmail(String s) { eEmail = trimAndConvert(s,"<>\"");  }
	public void setePassword(String s) {ePassword = s.trim();                  }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (cEmail == null || cEmail.length() == 0) {
			errors.add("User Name is required");
		}
		if (eEmail == null || eEmail.length() == 0) {
			errors.add("User Name is required");
		}
		
		if (cPassword == null || cPassword.length() == 0) {
			errors.add("Password is required");
		}
		if (ePassword == null || ePassword.length() == 0) {
			errors.add("Password is required");
		}		
		return errors;
	}
}