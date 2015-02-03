package com.hsq.daily.service;

import java.util.ArrayList;
import com.hsq.daily.domain.Tag;

/*author:huangshanqi
 *time  :2015年2月1日 下午9:19:28
 *email :hsqmobile@gmail.com
 */
public interface TagService {

	
	public int createTag(Tag tag);
	public boolean deleteTag(int id);
	public Tag findById(int id);
	public ArrayList<Tag> getAllTag();
	public ArrayList<Tag> getUserAllTag();
	public Tag getByName(String name);
}
