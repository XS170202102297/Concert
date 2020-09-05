package action;

import java.util.Map;
import java.util.regex.Pattern;


import dao.UserDao;
import models.User;
import utils.Config;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport {
	private User user;
	private String rePassword;// 确认密码
	private String oldPassword;// 旧密码
	private String newPassword;// 新密码
	private String newPhone;// 新联系电话
	private String newName;
	private String email;
	
	private UserDao ud;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDao getUd() {
		return ud;
	}


	public void setUd(UserDao ud) {
		this.ud = ud;
	}


	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
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


	public String getNewPhone() {
		return newPhone;
	}

	public void setNewPhone(String newPhone) {
		this.newPhone = newPhone;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
	
	/**
	 * 注册数据校验方法
	 */
	public void validateRegister() {
		if (user.getUsername() == null || user.getUsername().equals(""))
			addFieldError("user.username", "用户名不能为空！");
		else if (!Pattern.matches("[a-zA-Z][a-zA-Z0-9]{0,7}",
				user.getUsername()))
			addFieldError("user.username", "用户名请使用1~8位英文字母或数字，且以字母开头！");// 校验用户名

		if (user.getPassword() == null
				|| user.getPassword().equals(""))
			addFieldError("user.password", "密码不能为空！");
		else if (!Pattern.matches("[a-zA-Z0-9]{4,10}", user.getPassword()))
			addFieldError("user.password", "密码请使用4~10位英文字母或数字！");// 校验密码

		if (rePassword == null || rePassword.length()==0)
			addFieldError("rePassword", "确认密码不能为空！");
		else if (!rePassword.equals(user.getPassword()))
			addFieldError("rePassword", "两次密码不一致！");// 校验确认密码
		
		
		
		
//		if (email == null || email.length()==0)
//			addFieldError("email", "邮箱不能为空！");
//		else if (email.indexOf("@")!=-1 && email.indexOf(".")!=-1)
//			addFieldError("email", "邮箱输入必须包含@或.");

		
		
		
		
		if (user.getMobilePhone() == null
				|| user.getMobilePhone().equals(""))
			addFieldError("user.mobilePhone", "电话号码不能为空！");// 校验电话号码
		else if (!Pattern.matches("[0-9]{11}", user.getMobilePhone()))
			addFieldError("user.mobilePhone", "请输入正确的电话号码（11位）！");// 校验密码


		}
	

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	public String register() {
		ud.addUser(user);
		return "register";
	}

	/**
	 * 登录数据校验方法
	 */
	public void validateLogin() {
		
		if (user.getUsername() == null || user.getUsername().equals(""))
			addFieldError("user.username", "用户名不能为空！");// 校验用户名
		if (user.getPassword() == null
				|| user.getPassword().equals(""))
			addFieldError("user.password", "密码不能为空！");// 校验密码
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String login() {
		Map session = ActionContext.getContext().getSession();
		User currentCus = ud.checkLogin(user);
		if (currentCus != null) {
			session.put(Config.CURRENTCUS, currentCus);
			return "login";
		} else {
			addFieldError("user.username", "用户名或密码不存在！");
			return "input";
		}
	}

	/**
	 * 验证密码是否为空
	 */
	public void validateUpdatePassword() {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get(Config.CURRENTCUS);
		if (oldPassword == null || oldPassword.length()==0) {
			addFieldError("oldPassword", "旧密码不能为空！");
		}
		if (!oldPassword.equals(user.getPassword())) {
			addFieldError("oldPassword", "旧密码不正确！");
		}
		if (newPassword == null || newPassword.length()==0) {
			addFieldError("newPassword", "新密码不能为空！");
		} else if (!Pattern
				.matches("[a-zA-Z0-9]{4,10}", user.getPassword()))
			addFieldError("user.password", "密码请使用4~10位英文字母或数字！");
		if (rePassword == null || rePassword.length()==0) {
			addFieldError("rePassword", "确认密码不能为空！");
		} else if (!rePassword.equals(newPassword)) {
			addFieldError("rePassword", "两次密码不一致！");
		}
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	public String updatePassword() {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get(Config.CURRENTCUS);
		if (ud.updatePassword(newPassword, user)) {
			// if(session.get(Config.CURRENTCUS)!=null){
			// session.remove(Config.CURRENTCUS);
			// }
			((User) session.get(Config.CURRENTCUS)).setPassword(newPassword);
			return "updatePassword";
		}
		return "input";

	}

	/**
	 * 校验修改的个人信息
	 */
	public void validateUpdateInfo() {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get(Config.CURRENTCUS);
		if (newName == null || newName.equals("")) {
			newName = user.getUsername();
		} else if (!Pattern.matches("[a-zA-Z][a-zA-Z0-9]{1,7}", newName))
			addFieldError("newName", "用户名请使用2~8位英文字母或数字，且以字母开头！");
		
		if (newPhone == null || newPhone.equals(""))
			newPhone = user.getMobilePhone();// 校验电话号码
		else if (!Pattern.matches("[0-9]{11}", newPhone))
			addFieldError("newPhone", "请输入正确的电话号码（11位）！");

	}
	//public void validate(){
//	
//	if(user.getUserName()==null||user.getUserName().trim().equals("")){
//		addActionError("用户名不能为空！");
//	}
//	if(user.getEmail()==null||user.getEmail().trim().equals("")){
//		addActionError("邮箱不能为空！");
//	}
//	
//	if(user.getMobilePhone()!=null&&!user.getMobilePhone().trim().equals("")){
//		if(user.getMobilePhone().trim().length()>11||user.getMobilePhone().trim().length()<11){
//			addActionError("手机号码必须为11位数字，您的号码为非法号码！");
//		}
//		else if(!checknumber(user.getMobilePhone().substring(0, 10))){
//			addActionError("手机号码必须为数字类型，您的号码为非法号码！");
//		}
//	}
//	
//	}
		


	/**
	 * 更新个人信息
	 * 
	 * @return
	 */
	public String updateInfo() {
		Map session = ActionContext.getContext().getSession();
		user = (User) session.get(Config.CURRENTCUS);
		user.setUsername(newName);
		user.setMobilePhone(newPhone);
		if (ud.updateInfo(user)) {
			((User) session.get(Config.CURRENTCUS)).setUsername(newName);
			((User) session.get(Config.CURRENTCUS)).setMobilePhone(newPhone);

			return showInfo();
		}
		return "input";
	}

	public String showInfo() {
		user = ud.showInfo(user.getId2());
		return "showInfo";
	}

}
