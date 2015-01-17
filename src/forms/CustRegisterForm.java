package forms;

import org.mybeans.form.FormBean;

public class CustRegisterForm extends FormBean {
	String fname;
	String lname;
	String custAddress1;
	String custAddress2;
	String custCity;
	String custState;
	String custUsername;
	String custPassword;
	String custZip;
	String custCashValue;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = trimAndConvert(fname, "<>\"");
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = trimAndConvert(lname, "<>\"");
	}
	public String getCustAddress1() {
		return custAddress1;
	}
	public void setCustAddress1(String custAddress1) {
		this.custAddress1 = trimAndConvert(custAddress1, "<>\"");;
	}
	public String getCustAddress2() {
		return custAddress2;
	}
	public void setCustAddress2(String custAddress2) {
		this.custAddress2 = trimAndConvert(custAddress2, "<>\"");
	}
	public String getCustCity() {
		return custCity;
	}
	public void setCustCity(String custCity) {
		this.custCity = trimAndConvert(custCity, "<>\"");
	}
	public String getCustState() {
		return custState;
	}
	public void setCustState(String custState) {
		this.custState = trimAndConvert(custState, "<>\"");
	}
	public String getCustZip() {
		return custZip;
	}
	public void setCustZip(String custZip) {
		this.custZip = trimAndConvert(custZip, "<>\"");
	}
	public String getCustCashValue() {
		return custCashValue;
	}
	public void setCustCashValue(String custCashValue) {
		this.custCashValue = trimAndConvert(custCashValue, "<>\"");
	}
	public String getCustUsername() {
		return custUsername;
	}
	public void setCustUsername(String custUsername) {
		this.custUsername = trimAndConvert(custUsername, "<>\"");
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

}
