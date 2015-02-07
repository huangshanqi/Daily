package com.hsq.daily.service;

import java.util.ArrayList;
import java.util.List;

import com.hsq.daily.domain.Blog;

/*author:huangshanqi
 *time  :2015年2月6日 上午12:55:11
 *email :hsqmobile@gmail.com
 */
public interface BlogService {

	public int createBlog(Blog blog,List<Integer> tagIdList);
	public Blog getBlogById(int blogId);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlogById(int blogId);
	public ArrayList<Blog> getUserAllBlog(int userId);
	public ArrayList<Blog> getUserBlogByPage(int userId,int pageNum,int pageSize);
	public ArrayList<Blog> getUserBlogByCategory(int userId,int categoryId);
	public ArrayList<Blog> getUserBlogByCategoryByPage(int userId,int categoryId,int pageNum,int pageSize);
	public ArrayList<Blog> getUserBlogByTag(int userId,int tagId);
	public ArrayList<Blog> getUserBlogByTagByPage(int userId,int tagId,int pageNum,int pageSize);
}
