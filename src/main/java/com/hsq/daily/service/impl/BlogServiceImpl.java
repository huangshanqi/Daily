package com.hsq.daily.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsq.daily.dao.BlogDao;
import com.hsq.daily.dao.BlogTagDao;
import com.hsq.daily.dao.TagDao;
import com.hsq.daily.domain.Blog;
import com.hsq.daily.domain.BlogTag;
import com.hsq.daily.domain.Page;
import com.hsq.daily.domain.Tag;
import com.hsq.daily.service.BlogService;
import com.hsq.daily.utils.Constants;

/*author:huangshanqi
 *time  :2015年2月6日 上午1:04:35
 *email :hsqmobile@gmail.com
 */
@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private BlogTagDao blogTagDao;
	
	@Autowired
	private TagDao tagDao;

	@Transactional
	@Override
	public int createBlog(Blog blog, List<Integer> tagIdList) {
		// TODO Auto-generated method stub
		
		int blogId = blogDao.create(blog);
		if(blogId > 0){
			for(Integer tagId:tagIdList){
				Tag tag = tagDao.findById(tagId);
				if(tag!=null){
					BlogTag temp = new BlogTag();
					temp.setBlogId(blogId);
					temp.setTagId(tagId);
					blogTagDao.create(temp);
				}
			}
			return blogId;
		}else{
			return -1;
		}
	}

	@Override
	public Blog getBlogById(int blogId) {
		// TODO Auto-generated method stub
		return blogDao.findById(blogId);
	}

	@Override
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.updateBlog(blog)>0;
	}

	@Transactional
	@Override
	public boolean deleteBlogById(int blogId) {
		// TODO Auto-generated method stub
		Blog temp = blogDao.findById(blogId);
		if(temp == null){
			return false;
		}
		return (blogDao.deleteById(blogId)>0) && (blogTagDao.deleteBlogTag(blogId)>0);
	}

	@Override
	public ArrayList<Blog> getUserAllBlog(int userId) {
		// TODO Auto-generated method stub
		return blogDao.getUserAllBlog(userId);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ArrayList<Blog> getUserBlogByPage(int userId,int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		pageNum = (pageNum>0) ? pageNum : 1;
		pageSize = (pageSize>0)?(pageSize>Constants.MaxPageSize?Constants.MaxPageSize:pageSize):Constants.pageSize;
		Page page = new Page();
		page.setPageSize(pageSize);
		page.setOffset((pageNum-1)*pageSize);
		Map map = new HashMap<String,Integer>();
		map.put("userId",userId);
		page.setCondition(map);
		return blogDao.getUserBlogByPage(page);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ArrayList<Blog> getUserBlogByCategory(int userId, int categoryId) {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setPageSize(0);
		page.setOffset(0);
		Map map = new HashMap<String,Integer>();
		map.put("userId", userId);
		map.put("categoryId", categoryId);
		page.setCondition(map);
		
		return blogDao.getUserBlogByCategoryId(page);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ArrayList<Blog> getUserBlogByCategoryByPage(int userId, int categoryId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		pageNum = (pageNum>0) ? pageNum : 1;
		pageSize = (pageSize>0)?(pageSize>Constants.MaxPageSize?Constants.MaxPageSize:pageSize):Constants.pageSize;
		Page page = new Page();
		page.setPageSize(pageSize);
		page.setOffset((pageNum-1)*pageSize);
		Map map = new HashMap<String,Integer>();
		map.put("userId",userId);
		map.put("categoryId",categoryId);
		page.setCondition(map);
		return blogDao.getUserBlogByCategoryIdByPage(page);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ArrayList<Blog> getUserBlogByTag(int userId, int tagId) {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setPageSize(0);
		page.setOffset(0);
		Map map = new HashMap<String,Integer>();
		map.put("userId",userId);
		map.put("tagId",tagId);
		page.setCondition(map);
		return blogDao.getUserBlogByTag(page);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ArrayList<Blog> getUserBlogByTagByPage(int userId, int tagId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		pageNum = (pageNum>0) ? pageNum : 1;
		pageSize = (pageSize>0)?(pageSize>Constants.MaxPageSize?Constants.MaxPageSize:pageSize):Constants.pageSize;
		Page page = new Page();
		page.setPageSize(pageSize);
		page.setOffset((pageNum-1)*pageSize);
		Map map = new HashMap<String,Integer>();
		map.put("userId",userId);
		map.put("tagId",tagId);
		page.setCondition(map);
		return blogDao.getUserBlogByTagByPage(page);
	}

}
