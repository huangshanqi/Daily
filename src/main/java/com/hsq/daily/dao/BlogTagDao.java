package com.hsq.daily.dao;

import java.util.ArrayList;

import com.hsq.daily.domain.BlogTag;

/*author:huangshanqi
 *time  :2015年2月7日 上午1:05:12
 *email :hsqmobile@gmail.com
 */
public interface BlogTagDao extends BaseDao<BlogTag> {
	
	public ArrayList<BlogTag> getBlogAllTag(int blogId);
	public int deleteBlogTag(int blogId);
	public BlogTag getByBlogIdTagid(BlogTag blogTag);
}
