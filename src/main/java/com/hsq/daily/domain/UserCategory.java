package com.hsq.daily.domain;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2015年2月1日 下午10:41:46
 *email :hsqmobile@gmail.com
 */
public class UserCategory implements Serializable {

	private int id;
	private int userId;
	private int categoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
