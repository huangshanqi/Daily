package com.hsq.daily.domain;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2015年2月1日 下午8:43:16
 *email :hsqmobile@gmail.com
 */
public class Category implements Serializable {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
