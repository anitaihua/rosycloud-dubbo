package cn.rosycloud.utils;

import cn.rosycloud.config.HttpStatusCode;

/**
 * Title: 统一响应结构 
 * Description:使用REST框架实现前后端分离架构，我们需要首先确定返回的JSON响应结构是统一的，
 * 也就是说，每个REST请求将返回相同结构的JSON响应结构。不妨定义一个相对通用的JSON响应结构，其
 * 中包含两部分：元数据与返回值，其中，元数据表示操作是否成功与返回值消息等，返回值对应服务端方法所返回的数据。
 * { "meta": { "success": true, "message": "ok" }, "data": ... }
 * 
 * @author yangdaihua
 * @created 2017年7月4日 下午5:06:00
 */
public class Response {

	private static final String OK = "ok";
	private static final String ERROR = "error";

	private Meta meta;     // 元数据
	private Object data;   // 响应内容

	public Response success() {
		this.meta = new Meta(true, OK);
		return this;
	}

	public Response success(Object data) {
		this.meta = new Meta(true, OK);
		this.data = data;
		return this;
	}

	public Response failure() {
		this.meta = new Meta(false, HttpStatusCode.ERROR, ERROR);
		return this;
	}

	public Response failure(String message) {
		this.meta = new Meta(false, HttpStatusCode.ERROR, message);
		return this;
	}

	public Response failure(Integer errorCode,String message) {
		this.meta = new Meta(false, errorCode, message);
		return this;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Meta getMeta() {
		return meta;
	}

	public Object getData() {
		return data;
	}

	/**
	 * Title: 请求元数据
	 * @author yangdaihua
	 * @created 2017年7月4日 下午5:08:12
	 */
	public class Meta {

		private boolean success;
		private String message;
		private Integer errorCode = 200;

		public Meta(boolean success) {
			this.success = success;
		}

		public Meta(boolean success, String message) {
			this.success = success;
			this.message = message;
		}

		public Meta(boolean success,Integer errorCode, String message) {
			this.success = success;
			this.errorCode = errorCode;
			this.message = message;
		}

		public Integer getErrorCode() {
			return errorCode;
		}

		public boolean isSuccess() {
			return success;
		}

		public String getMessage() {
			return message;
		}
	}
}