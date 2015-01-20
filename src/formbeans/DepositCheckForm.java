package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class DepositCheckForm extends FormBean{
	private int customer_id;
	private String cusBalance;
	
	public int getCustomer_id() { return customer_id; }
	public String getCusBalance() { return cusBalance;}
	
	public void setCustomer_id(int i) { customer_id = i; }
	public void setCusBalance(String s) { cusBalance = s; }
	
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
