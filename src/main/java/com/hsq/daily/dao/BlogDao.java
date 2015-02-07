package com.hsq.daily.dao;

import java.util.ArrayList;

import com.hsq.daily.domain.Blog;
import com.hsq.daily.domain.Page;

/*author:huangshanqi
 *time  :2015年2月6日 上午12:28:57
 *email :hsqmobile@gmail.com
 */
public interface BlogDao extends BaseDao<Blog> {

	
	public int updateBlog(Blog blog);
	public ArrayList<Blog> getUserAllBlog(int userId);
	public ArrayList<Blog> getUserBlogByPage(Page page);
	public ArrayList<Blog> getUserBlogByCategoryId(Page page);
	public ArrayList<Blog> getUserBlogByCategoryIdByPage(Page page);
	public ArrayList<Blog> getUserBlogByTag(Page page);
	public ArrayList<Blog> getUserBlogByTagByPage(Page page);
	
	
}
