package com.hsq.daily.dao;

import com.hsq.daily.domain.UserCategory;
import com.hsq.daily.domain.UserTag;

/*author:huangshanqi
 *time  :2015年2月3日 下午10:08:14
 *email :hsqmobile@gmail.com
 */
public interface UserTagDao extends BaseDao<UserTag> {
	
	boolean deleteUserTag(int uerId,int tagId);

}
