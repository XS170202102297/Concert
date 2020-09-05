package Interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.*;
//登录拦截器
public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		
		Map session = ai.getInvocationContext().getSession();
		String username = (String)session.get("username");
		if(username!=null){//已经登陆
			return ai.invoke();
		}else{
			ActionContext ac=ai.getInvocationContext();
			ac.put("errorMessage", "您还没登录，请先登录");
			return "login";
		}
		
	}

}
