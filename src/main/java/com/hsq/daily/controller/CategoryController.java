package com.hsq.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsq.daily.domain.Category;
import com.hsq.daily.model.ResultCode;
import com.hsq.daily.model.ResultModel;
import com.hsq.daily.model.ResultModelUtils;
import com.hsq.daily.model.SessionModel;
import com.hsq.daily.security.UserUtils;
import com.hsq.daily.service.CategoryService;

/*author:huangshanqi
 *time  :2015年2月1日 下午8:42:55
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "cate")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@ResponseBody
	@RequestMapping(value = "new", method = RequestMethod.POST, params = { "name" })
	public Object createCategory(@ModelAttribute Category category) {
		ResultModel resultModel = null;

		if (categoryService.createCategory(category) > 0) {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.CATEGORY_CREATE_ERROR);
		}
		return resultModel;
	}

	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST, params = { "categoryId" })
	public Object deleteCategoryById(@RequestParam("categoryId") int categoryId) {
		ResultModel resultModel = null;

		if (categoryService.deleteCategory(categoryId)) {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.CATEGORY_DELETE_ERROR);
		}
		return resultModel;
	}

	/**
	 * 得到所有的分类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public Object getAllCategory() {
		ResultModel resultModel = null;

		SessionModel session = UserUtils.getLoginUser();
		resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		resultModel.setData(categoryService.getAllCategory());
		return resultModel;
	}
	
	/**
	 * 得到用户所有的分类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Object getUserAllCategory() {
		ResultModel resultModel = null;

		resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		resultModel.setData(categoryService.getUserAllCategory());
		return resultModel;
	}

}
