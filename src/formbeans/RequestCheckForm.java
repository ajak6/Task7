package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RequestCheckForm extends FormBean{
	private String cusBalance;
	
	public String getCusBalance() { return cusBalance;}
	public void setCusBalance(String s) { cusBalance = trimAndConvert(s, "<>\""); }
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (Long.parseLong(cusBalance) <= 0) {
			errors.add("Amount must be positive");
		}
		
		if (errors.size() > 0) {
			return errors;
		}
		
		return errors;
	}
}
