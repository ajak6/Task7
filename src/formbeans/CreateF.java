package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class CreateF extends FormBean {
	private String fundSym;
	private String fundName;
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (fundSym == ""||fundName == "") {
			errors.add("enter fund symbol or fund name");
		}
		
		if (errors.size() > 0) {
			return errors;
		}
		
		return errors;
	}
}

