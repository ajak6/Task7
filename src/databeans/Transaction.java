package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("transaction_id")
public class Transaction {
	private int transaction_id, customer_id, fund_id;
	private String execute_date, transaction_type, fund_name;
	private long share_price;
	private long shares, amount;
	
	public long getShare_price() {
		return share_price;
	}

	public void setShare_price(long share_price) {
		this.share_price = share_price;
	}

	public String getFund_Name() {
		return fund_name;
	}

	public void setFund_Name(String fund_name) {
		this.fund_name = fund_name;
	}

    

	//Getter
	public int getTransaction_id() {
		return transaction_id;
	}
	
	public int getCustomer_id() {
		return customer_id;
	}

	public int getFund_id() {
		return fund_id;
	}
	
	public String getExecute_date() {
		return execute_date;
	}
	
	public String getTransaction_type() {
		return transaction_type;
	}
	
	public long getShares() {
		return shares;
	}
	
	public long getAmount() {
		return amount;
	}
	
	//Setter
	public void setTransaction_id(int i){
		transaction_id = i;
	}
	
	public void setCustomer_id(int i){
		customer_id = i;
	}
	
	public void setFund_id(int i){
		fund_id = i;
	}
	
	public void setExecute_date(String s) {
		execute_date = s;
	}
	
	public void setShares(long l) {
		shares = l;
	}
	
	public void setTransaction_type(String s) {
		transaction_type = s;
	}
	
	public void setAmount(long l) {
		amount = l;
	}
}
