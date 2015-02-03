package com.hsq.daily.dao;

import java.util.ArrayList;
import com.hsq.daily.domain.Category;

/*author:huangshanqi
 *time  :2015年2月1日 下午8:51:07
 *email :hsqmobile@gmail.com
 */
public interface CategoryDao extends BaseDao<Category>{
	public ArrayList<Category> getAllCategory();
	public ArrayList<Category> getUserAllCategory(int userId);
	public Category getByUserIdName(Category category);
}
