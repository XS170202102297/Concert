package Action;

import com.opensymphony.xwork2.ActionSupport;

import Dao.CustomerDao;
import Model.Customer;


public class RegAction extends ActionSupport{
	private Customer custRegister;
	private CustomerDao cd;
	
	public RegAction(){
		
	}
	
	public Customer getCustRegister() {
		return custRegister;
	}

	public void setCustRegister(Customer custRegister) {
		this.custRegister = custRegister;
	}

	
	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public String execute()throws Exception{
	
		if(cd.registerUser(custRegister)>0){			
			return SUCCESS;
		}else{
			addFieldError("custRegister.username","用户名错误");
			addFieldError("custRegister.password","密码错误");
			return INPUT; 
		}
	}
	
}


