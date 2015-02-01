package com.hsq.daily.domain;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2015年2月1日 下午10:42:37
 *email :hsqmobile@gmail.com
 */
public class UserTag implements Serializable {

	private int id;
	private int userId;
	private int tagId;

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

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

}
