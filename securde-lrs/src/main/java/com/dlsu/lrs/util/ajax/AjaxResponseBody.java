package com.dlsu.lrs.util.ajax;

import org.springframework.http.HttpStatus;

public class AjaxResponseBody<T> {

	private Boolean success;
	private Integer status;
	private String message;
	private Object errorData;
	private T data;
	
	public AjaxResponseBody() { }
	public AjaxResponseBody(Integer status, String message) {
		this.success = status < 400;
		this.status = status;
		this.message = message;
	}
	public AjaxResponseBody(Integer status, String message, T data) {
		this(status, message);
		this.data = data;
	}
	public AjaxResponseBody(HttpStatus status) {
		this(status.value(), status.getReasonPhrase());
	}
	public AjaxResponseBody(HttpStatus status, T data) {
		this(status);
		this.data = data;
	}

	public Boolean isSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getErrorData() {
		return errorData;
	}
	public void setErrorData(Object errorData) {
		this.errorData = errorData;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
