package com.dlsu.lrs.util;

public class AjaxResponse<T> implements Jsonifiable {

	private Boolean success;
	private Integer code;
	private String message;
	private T data;
	private Object errorData;
	
	public AjaxResponse() { }
	public AjaxResponse(Boolean success, Integer code, String message, T data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static <E> AjaxResponse<E> success(Integer code, String message) {
		return new AjaxResponse<E>()
				.setSuccess(true)
				.setCode(code)
				.setMessage(message);
	}
	public static <E> AjaxResponse<E> error(Integer code, String message) {
		return new AjaxResponse<E>()
				.setSuccess(false)
				.setCode(code)
				.setMessage(message);
	}
	public static AjaxResponse<?> ok() {
		return new AjaxResponse<>()
				.setSuccess(true)
				.setCode(200)
				.setMessage("OK");
	}
	public static <E> AjaxResponse<E> created(E data) {
		return new AjaxResponse<E>()
				.setSuccess(true)
				.setCode(201)
				.setMessage("Created")
				.setData(data);
	}
	public static <E> AjaxResponse<E> success(Integer code, E data) {
		return new AjaxResponse<E>()
				.setSuccess(true)
				.setCode(code)
				.setData(data);
	}

	public static <E> AjaxResponse<E> unauthorized() {
		return new AjaxResponse<E>()
				.setSuccess(false)
				.setCode(401)
				.setMessage("Unauthorized");
	}
	public static <E> AjaxResponse<E> forbidden() {
		return new AjaxResponse<E>()
				.setSuccess(false)
				.setCode(403)
				.setMessage("Forbidden");
	}
	public static <E> AjaxResponse<E> notFound() {
		return new AjaxResponse<E>()
				.setSuccess(false)
				.setCode(404)
				.setMessage("Not Found");
	}
	public static <E> AjaxResponse<E> conflict() {
		return new AjaxResponse<E>()
				.setSuccess(false)
				.setCode(409)
				.setMessage("Conflict");
	}
	public static <E> AjaxResponse<E> internalServerError() {
		return new AjaxResponse<E>()
				.setSuccess(false)
				.setCode(500)
				.setMessage("Internal server error");
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public AjaxResponse<T> setSuccess(Boolean success) {
		this.success = success;
		return this;
	}
	
	public Integer getCode() {
		return code;
	}
	public AjaxResponse<T> setCode(Integer code) {
		this.code = code;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	public AjaxResponse<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public T getData() {
		return data;
	}
	public AjaxResponse<T> setData(T data) {
		this.data = data;
		return this;
	}

	public Object getErrorData() {
		return errorData;
	}
	public AjaxResponse<T> setErrorData(Object errorData) {
		this.errorData = errorData;
		return this;
	}
}
