package com.hsq.daily.domain;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2015年1月31日 下午7:55:12
 *email :hsqmobile@gmail.com
 */
public class Tag implements Serializable {

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
