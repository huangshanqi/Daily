package com.hsq.daily.controller;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*author:huangshanqi
 *time  :2015年1月31日 下午4:01:32
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "/user")
public class MainController {
	
	@RequestMapping(value = "index",method = RequestMethod.GET)
	@ResponseBody
	public Object index(){
		return new Date();
	}

}
