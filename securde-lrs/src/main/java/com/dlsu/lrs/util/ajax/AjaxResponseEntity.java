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
}
