package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("fund_id,price_date")
public class Fund_Price_History {
	private int fund_id;
	private String price_date;
	private long price;
	
	//Getter
	public int getFund_id() {
		return fund_id;
	}
	
	public String getPrice_date() {
		return price_date;
	}
	
	public long getPrice() {
		return price;
	}
	
	//Setter
	public void setFund_id(int i){
		fund_id = i;
	}
	
	public void setPrice_date(String s){
		price_date = s;
	}
	
	public void setPrice(long l) {
		price = l;
	}

}
