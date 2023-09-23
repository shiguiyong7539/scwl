package com.scwl.pojo;

/**
 * 公共返回对象
 *
 * @author zhoubin
 * @since 1.0.0
 */

public class ResBean {
	private long code;
	private String message;
	private Object obj;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public ResBean(long code, String message, Object obj) {
		this.code = code;
		this.message = message;
		this.obj = obj;
	}

	/**
	 * 成功返回结果
	 * @param message
	 * @return
	 */
	public static ResBean success(String message){
		return new ResBean(200,message,null);
	}

	/**
	 * 成功返回结果
	 * @param message
	 * @param obj
	 * @return
	 */
	public static ResBean success(String message,Object obj){
		return new ResBean(200,message,obj);
	}

	/**
	 * 失败返回结果
	 * @param message
	 * @return
	 */
	public static ResBean error(String message){
		return new ResBean(500,message,null);
	}

	/**
	 * 失败返回结果
	 * @param message
	 * @param obj
	 * @return
	 */
	public static ResBean error(String message,Object obj){
		return new ResBean(500,message,obj);
	}
}