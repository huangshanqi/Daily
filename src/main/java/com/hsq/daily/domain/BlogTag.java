package com.hsq.daily.domain;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2015年1月31日 下午7:56:12
 *email :hsqmobile@gmail.com
 */
public class BlogTag implements Serializable {

	private int id;
	private int blogId;
	private int tagId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

}
