package com.hsq.daily.model;


/*author:huangshanqi
 *time  :2014年10月7日 下午2:23:25
 *email :hsqmobile@gmail.com
 */
public enum ResultCode {

	OK("20000", "ok"),
	USER_CREATE_ERROR("50000","创建用户失败"),
	USER_MODIFY_USERNAME_ERROR("50001","修改用户名失败"),
	USER_MODIFY_PASSWORD_ERROR("50002","修改用户密码失败"),
	
	CATEGORY_CREATE_ERROR("50010","创建分类失败"),
	CATEGORY_DELETE_ERROR("50011","删除分类失败"),
	
	
	
	
	
	;
	
	
	private  String code;// 错误码
	private String  message; // 错误信息

	private ResultCode(String code, String message) {
		this.code = code;
		this.message = message;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
