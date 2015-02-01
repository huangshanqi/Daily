package com.hsq.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsq.daily.domain.User;
import com.hsq.daily.model.ResultCode;
import com.hsq.daily.model.ResultModel;
import com.hsq.daily.model.ResultModelUtils;
import com.hsq.daily.service.UserService;

/*author:huangshanqi
 *time  :2015年1月31日 下午9:15:29
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "register",method = RequestMethod.POST,params = {"username","email","password"})
	public Object createUser(@ModelAttribute User user){
		
		ResultModel resultModel = null;
		
		if(userService.createUser(user) > 0 ){
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.USER_CREATE_ERROR);
		}
		return resultModel;
	}
	
	@ResponseBody
	@RequestMapping(value = "modify",method = RequestMethod.POST,params = {"userId","username"})
	public Object modifyName(@RequestParam("userId") int userId,@RequestParam("username") String username){
		ResultModel resultModel = null;
		if(userService.updateUsername(userId, username)){
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.USER_MODIFY_USERNAME_ERROR);
		}
		return resultModel;
	}
	
	@ResponseBody
	@RequestMapping(value = "modify",method = RequestMethod.POST,params = {"userId","password"})
	public Object modifyPassword(@RequestParam("userId") int userId,@RequestParam("password") String password){
		ResultModel resultModel = null;
		if(userService.updatePassword(userId, password)){
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.USER_MODIFY_PASSWORD_ERROR);
		}
		return resultModel;
	}

}
