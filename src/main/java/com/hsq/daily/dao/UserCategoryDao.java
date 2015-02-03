package com.hsq.daily.dao;

import com.hsq.daily.domain.UserCategory;

/*author:huangshanqi
 *time  :2015年2月3日 下午10:08:14
 *email :hsqmobile@gmail.com
 */
public interface UserCategoryDao extends BaseDao<UserCategory> {
	
	boolean deleteUserCategory(int uerId,int categoryId);

}
