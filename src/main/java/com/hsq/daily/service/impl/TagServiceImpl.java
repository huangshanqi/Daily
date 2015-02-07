package com.hsq.daily.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsq.daily.dao.TagDao;
import com.hsq.daily.domain.Tag;
import com.hsq.daily.service.TagService;

/*author:huangshanqi
 *time  :2015年2月3日 下午11:14:22
 *email :hsqmobile@gmail.com
 */
@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagDao tagDao;

	@Transactional
	@Override
	public int createTag(Tag tag) {
		// TODO Auto-generated method stub
		Tag temp = tagDao.getByUserIdName(tag);
		if(temp != null){
			return -1;
		}
		return tagDao.create(tag);
	}

	@Override
	public boolean deleteTag(int id) {
		// TODO Auto-generated method stub
		return tagDao.deleteById(id)>0;
	}

	@Override
	public Tag findById(int id) {
		// TODO Auto-generated method stub
		return tagDao.findById(id);
	}

	@Override
	public ArrayList<Tag> getAllTag() {
		// TODO Auto-generated method stub
		return tagDao.getAllTag();
	}

	@Override
	public ArrayList<Tag> getUserAllTag(int userId) {
		// TODO Auto-generated method stub
		return tagDao.getUserAllCategoryTag(userId);
	}

	@Override
	public Tag getByUserIdName(Tag tag) {
		// TODO Auto-generated method stub
		return tagDao.getByUserIdName(tag);
	}

	

}
