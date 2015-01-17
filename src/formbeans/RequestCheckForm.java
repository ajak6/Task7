package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RequestCheckForm extends FormBean{
	private long amount;
	
	public long getAmount() { return amount;}
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
