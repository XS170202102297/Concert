package Action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Dao.CustomerDao;
import Model.Customer;

public class changePasswordAction extends ActionSupport{
	String oldPassword;
	String newPassword;
	String newPassword2;
	Customer custChange; 
	CustomerDao cd ;
	
	public changePasswordAction(){
		
	}

	public String getOldPassword() {
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	public String getNewPassword2() {
		return newPassword2;
	}


	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}


	public Customer getCustChange() {
		return custChange;
	}


	public void setCustChange(Customer custChange) {
		this.custChange = custChange;
	}


	public CustomerDao getCd() {
		return cd;
	}


	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}


	public String execute(){
		//��õ�ǰ��¼�û�
		Map map=ActionContext.getContext().getSession();
		custChange=(Customer)map.get("custLogin");
		if(cd.changePassword(custChange, oldPassword, newPassword)){
			return SUCCESS;
		}else{
			addFieldError("oldPassword","旧密码错误");
			return INPUT;
		}
	}
}
