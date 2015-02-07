package com.hsq.daily.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsq.daily.domain.Blog;
import com.hsq.daily.forms.BlogForm;
import com.hsq.daily.model.ResultCode;
import com.hsq.daily.model.ResultModel;
import com.hsq.daily.model.ResultModelUtils;
import com.hsq.daily.security.UserUtils;
import com.hsq.daily.service.BlogService;

/*author:huangshanqi
 *time  :2015年2月1日 下午8:13:50
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@ResponseBody
	@RequestMapping(value="new",method=RequestMethod.POST)
	public Object newBlog(@Valid BlogForm blogForm,BindingResult valid){
		ResultModel resultModel = new ResultModel();
		if(valid.hasErrors()){
			resultModel=ResultModelUtils.getResultModelByCode(ResultCode.Blog_CREATE_ERROR);
			resultModel.setData(valid.getFieldError().getDefaultMessage());
		}else{
			Blog blog = new Blog();
			blog.setUserId(UserUtils.getLoginUser().getUserId());
			blog.setCreateTime(new Date());
			blog.setTitle(blogForm.getTitle());
			blog.setContent(blogForm.getContent());
			blog.setCategoryId(blogForm.getCategoryId());
			
			List<Integer> tagIdList = new ArrayList<Integer>();
			for(String tagId:blogForm.getTagIdList().split(":")){
				tagIdList.add(Integer.valueOf(tagId));
			}
			if(blogService.createBlog(blog, tagIdList)>0){
				resultModel=ResultModelUtils.getResultModelByCode(ResultCode.OK);
			}else{
				resultModel=ResultModelUtils.getResultModelByCode(ResultCode.Blog_CREATE_ERROR);
			}
		}
		return resultModel;
	}
	
	
	 
}
