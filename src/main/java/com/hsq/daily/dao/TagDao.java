package com.hsq.daily.dao;

import java.util.ArrayList;

import com.hsq.daily.domain.Tag;

/*author:huangshanqi
 *time  :2015年2月1日 下午8:51:07
 *email :hsqmobile@gmail.com
 */
public interface TagDao extends BaseDao<Tag>{
	public ArrayList<Tag> getAllTag();
	public ArrayList<Tag> getUserAllCategoryTag(int userId);
	public Tag getByName(String name);
}
