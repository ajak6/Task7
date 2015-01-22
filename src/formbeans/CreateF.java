package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class CreateF extends FormBean {
	private String fundSym;
	private String fundName;
	private String action;
	public String getfundSym()  { return fundSym;  }
	public String getfundName()  { return fundName;  }
	public String getAction()  { return action; }
	
	public void setfundSym(String s)  { fundSym = trimAndConvert(s,"<>\"");        }
	public void setfundName(String s)  { fundName = trimAndConvert(s,"<>\""); }
	public void setAction(String s)  {action = s; }
	
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

