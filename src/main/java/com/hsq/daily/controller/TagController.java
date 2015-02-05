package com.hsq.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsq.daily.domain.Tag;
import com.hsq.daily.model.ResultCode;
import com.hsq.daily.model.ResultModel;
import com.hsq.daily.model.ResultModelUtils;
import com.hsq.daily.security.UserUtils;
import com.hsq.daily.service.TagService;

/*author:huangshanqi
 *time  :2015年2月1日 下午8:42:55
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "tag")
public class TagController {

	@Autowired
	private TagService tagService;

	@ResponseBody
	@RequestMapping(value = "new", method = RequestMethod.POST, params = { "name" })
	public Object createTag(@ModelAttribute Tag tag) {
		ResultModel resultModel = null;
        tag.setUserId(UserUtils.getLoginUser().getUserId());
		if (tagService.createTag(tag) > 0) {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.TAG_CREATE_ERROR);
		}
		return resultModel;
	}

	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST, params = { "tagId" })
	public Object deleteTagById(@RequestParam("tagId") int tagId) {
		ResultModel resultModel = null;

		if (tagService.deleteTag(tagId)) {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.TAG_DELETE_ERROR);
		}
		return resultModel;
	}

	/**
	 * 得到所有的分类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public Object getAllTag() {
		ResultModel resultModel = null;

		resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		resultModel.setData(tagService.getAllTag());
		return resultModel;
	}
	
	/**
	 * 得到用户所有的分类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Object getUserAllTag() {
		ResultModel resultModel = null;

		resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		resultModel.setData(tagService.getUserAllTag(UserUtils.getLoginUser().getUserId()));
		return resultModel;
	}

}
