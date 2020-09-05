package interceptor;

import java.util.Map;
import models.User;
import utils.Config;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserLoginCheck extends AbstractInterceptor{

	public String intercept(ActionInvocation ai) throws Exception {
		Map session = ai.getInvocationContext().getSession();
		User user = (User)session.get("user");
		if(user != null){
			return ai.invoke();
		}else{
			ActionContext ac = ai.getInvocationContext();
			ac.put("popedom", "您还没有登录，请登录!");
			return "login";
		}
	}
}
