package com.antbean.framework.web.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antbean.domain.request.PersonCreate;

@RestController
@RequestMapping("/person")
public class PersonController {
	@RequestMapping("/create")
	public Object create(@Validated PersonCreate person) {
		return "ok";
	}
}
