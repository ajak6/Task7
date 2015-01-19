package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class DepositCheckForm extends FormBean{
	private int customer_id;
	private long amount;
	
	public int getCustomer_id() { return customer_id; }
	public long getAmount() { return amount;}
	
	public void setCustomer_id(int i) { customer_id = i; }
	public void setAmount(long l) { amount = l; }
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (amount <= 0) {
			errors.add("Amount must be positive");
		}
		
		if (errors.size() > 0) {
			return errors;
		}
		
		return errors;
	}
}
