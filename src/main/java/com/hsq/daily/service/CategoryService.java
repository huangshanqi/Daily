package com.hsq.daily.service;

import java.util.ArrayList;
import java.util.List;

import com.hsq.daily.domain.Category;

/*author:huangshanqi
 *time  :2015年2月1日 下午9:19:28
 *email :hsqmobile@gmail.com
 */
public interface CategoryService {

	
	public int createCategory(Category category);
	public boolean deleteCategory(int id);
	public Category findById(int id);
	public ArrayList<Category> getAllCategory();
	public ArrayList<Category> getUserAllCategory();
	public Category getByName(String name);
}
