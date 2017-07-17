package com.dlsu.lrs.util.ajax;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class AjaxResponseEntity<T> extends ResponseEntity<AjaxResponseBody<T>> {
	
	public AjaxResponseEntity(T body, HttpStatus status) {
		super(new AjaxResponseBody<>(status, body), status);
	}
	public AjaxResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus status) {
		super(new AjaxResponseBody<>(status, body), headers, status);
	}
	public AjaxResponseEntity(HttpStatus status) {
		super(new AjaxResponseBody<>(status), status);
	}
	public AjaxResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
		super(new AjaxResponseBody<>(status), headers, status);
	}
	
	public Boolean isSuccess() {
		return getBody().isSuccess();
	}
	public AjaxResponseEntity<T> setSuccess(Boolean success) {
		getBody().setSuccess(success);
		return this;
	}
	public Integer getStatus() {
		return getBody().getStatus();
	}
	public AjaxResponseEntity<T> setStatus(Integer status) {
		getBody().setStatus(status);
		return this;
	}
	public String getMessage() {
		return getBody().getMessage();
	}
	public AjaxResponseEntity<T> setMessage(String message) {
		getBody().setMessage(message);
		return this;
	}
	public Object getErrorData() {
		return getBody().getErrorData();
	}
	public AjaxResponseEntity<T> setErrorData(Object errorData) {
		getBody().setErrorData(errorData);
		return this;
	}
	public T getData() {
		return getBody().getData();
	}
	public AjaxResponseEntity<T> setData(T data) {
		getBody().setData(data);
		return this;
	}
}
