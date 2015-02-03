package com.hsq.daily.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hsq.daily.dao.CategoryDao;
import com.hsq.daily.dao.TagDao;
import com.hsq.daily.dao.UserCategoryDao;
import com.hsq.daily.dao.UserTagDao;
import com.hsq.daily.domain.Category;
import com.hsq.daily.domain.Tag;
import com.hsq.daily.domain.UserCategory;
import com.hsq.daily.security.UserUtils;
import com.hsq.daily.service.TagService;

/*author:huangshanqi
 *time  :2015年2月3日 下午11:14:22
 *email :hsqmobile@gmail.com
 */
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagDao tagcategoryDao;
	@Autowired
	private UserTagDao userTagDao;

	@Override
	public int createTag(Tag tag) {
		// TODO Auto-generated method stub
		Category temp = categoryDao.getByUserIdName(category.getName());
		if(temp != null){
			return -1;
		}
		int categoryId = categoryDao.create(category);
		UserCategory userCategory = new UserCategory();
		userCategory.setUserId(UserUtils.getLoginUser().getUserId());
		userCategory.setCategoryId(categoryId);
		return UserCategoryDao.create(userCategory);return 0;
	}

	@Override
	public boolean deleteTag(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tag findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Tag> getAllTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Tag> getUserAllTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
