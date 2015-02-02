package com.hsq.daily.security;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsq.daily.domain.User;
import com.hsq.daily.model.SessionModel;
import com.hsq.daily.service.UserService;
@Service
public class ShiroDbRealm extends AuthorizingRealm {
	@Autowired
	protected UserService userService;

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userService.findUserByEmail(token.getUsername());
		if (user != null) {
			SessionModel session = new SessionModel();
			session.setUserId(user.getId());
			session.setEmail(user.getEmail());
			session.setUsername(user.getUsername());
			session.setExpireshIn(DateUtils.addDays(new Date(), 30).getTime());
			return new SimpleAuthenticationInfo(session, user.getPassword(),ByteSource.Util.bytes(""), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SessionModel shiroUser = (SessionModel) principals.getPrimaryPrincipal();
		User user = userService.findUserByEmail(shiroUser.getEmail());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// info.addRoles(user.getRoleList());
		return info;
	}
}
