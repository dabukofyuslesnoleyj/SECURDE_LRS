package com.dlsu.lrs.util;

public class AjaxResponse<T> implements Jsonifiable {

	private Boolean success;
	private Integer code;
	private String message;
	private T data;
	
	public AjaxResponse() { }
	public AjaxResponse(Boolean success, Integer code, String message, T data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static AjaxResponse<?> empty() {
		return new AjaxResponse<>();
	}
	
	public static AjaxResponse<?> success() {
		return new AjaxResponse<>().setSuccess(true);
	}
	public static <E> AjaxResponse<E> success(Integer code, String message) {
		return new AjaxResponse<E>()
				.setSuccess(true)
				.setCode(code)
				.setMessage(message);
	}
	public static <E> AjaxResponse<E> success(Integer code, E data) {
		return new AjaxResponse<E>()
				.setSuccess(true)
				.setCode(code)
				.setData(data);
	}
	
	public static AjaxResponse<?> error() {
		return new AjaxResponse<>().setSuccess(false);
	}
	public static <E> AjaxResponse<E> error(Integer code, String message) {
		return new AjaxResponse<E>()
				.setSuccess(false)
				.setCode(code)
				.setMessage(message);
	}
	public static <E> AjaxResponse<E> error(Exception e) {
		return new AjaxResponse<E>()
				.setSuccess(false)
				.setCode(500)
				.setMessage("Internal Server Error");
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
}
