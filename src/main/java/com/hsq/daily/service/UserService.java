package com.hsq.daily.service;

import com.hsq.daily.domain.User;

/*author:huangshanqi
 *time  :2015年1月31日 下午9:04:30
 *email :hsqmobile@gmail.com
 */
public interface UserService {
	

	
	public int createUser(User user);
	
	public User findUserByEmail(String email);
	public User findUserByUserName(String username);
	public User findUserByid(int userId);
	
	public boolean updateUsername(int userId,String username);
	public boolean updatePassword(int userId,String password);
	
	public boolean checkPassword(int userId,String password);
	public boolean updateEmailAuth(int userId,int emailAuthStatus);
	public boolean checkEmailAuth(int userId);

}
