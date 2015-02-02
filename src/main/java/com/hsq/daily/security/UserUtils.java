package com.hsq.daily.security;

import org.apache.shiro.SecurityUtils;
import com.hsq.daily.model.SessionModel;
public abstract class UserUtils { 

	public static SessionModel getLoginUser() {

		SessionModel user =null;
		 user = (SessionModel) SecurityUtils.getSubject().getPrincipal();

		return user;
	}
	
}
