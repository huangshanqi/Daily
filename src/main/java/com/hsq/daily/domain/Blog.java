package com.hsq.daily.domain;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2015年1月31日 下午7:53:50
 *email :hsqmobile@gmail.com
 */
public class Blog implements Serializable {

	private int id;
	private Date createTime;
	private String title;
	private String content;
	private int userId;
	private int CategoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

}
