package com.hsq.daily.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsq.daily.dao.CategoryDao;
import com.hsq.daily.domain.Category;
import com.hsq.daily.service.CategoryService;

/*author:huangshanqi
 *time  :2015年2月1日 下午9:32:25
 *email :hsqmobile@gmail.com
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Transactional
	@Override
	public int createCategory(Category category) {
		// TODO Auto-generated method stub
		Category temp = categoryDao.getByUserIdName(category);
		if(temp != null){
			return -1;
		}
		return categoryDao.create(category);
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return categoryDao.deleteById(id);
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
	public ArrayList<Category> getUserAllCategory(int userId) {
		// TODO Auto-generated method stub
		return categoryDao.getUserAllCategory(userId);
	}

	
	
	
	
	
}
