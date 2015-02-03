package com.hsq.daily.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsq.daily.dao.CategoryDao;
import com.hsq.daily.dao.UserCategoryDao;
import com.hsq.daily.domain.Category;
import com.hsq.daily.domain.UserCategory;
import com.hsq.daily.security.UserUtils;
import com.hsq.daily.service.CategoryService;

/*author:huangshanqi
 *time  :2015年2月1日 下午9:32:25
 *email :hsqmobile@gmail.com
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private UserCategoryDao UserCategoryDao;
	
	@Transactional
	@Override
	public int createCategory(Category category) {
		// TODO Auto-generated method stub
		Category temp = categoryDao.getByUserIdName(category);
		if(temp != null){
			return -1;
		}
		int categoryId = categoryDao.create(category);
		UserCategory userCategory = new UserCategory();
		userCategory.setUserId(UserUtils.getLoginUser().getUserId());
		userCategory.setCategoryId(categoryId);
		return UserCategoryDao.create(userCategory);
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		
		return categoryDao.deleteById(id) && UserCategoryDao.deleteUserCategory(UserUtils.getLoginUser().getUserId(), id);
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(id);
	}

	@Override
	public ArrayList<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategory();
	}

	@Override
	public Category getByName(String name) {
		// TODO Auto-generated method stub
		return categoryDao.getByName(name);
	}

	@Override
	public ArrayList<Category> getUserAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getUserAllCategory(UserUtils.getLoginUser().getUserId());
	}

	
	
	
	
	
}
