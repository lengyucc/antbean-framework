package com.antbean.framework.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antbean.framework.domain.entity.City;
import com.antbean.framework.service.impl.ICityService;

@RestController
@RequestMapping("/city")
public class CityController {
	@Autowired
	ICityService cityService;

	@RequestMapping("/get")
	public Object get(Long id) {
		return cityService.get(id);
	}
	
	@RequestMapping("/delete")
	public Object delete(Long id) {
		cityService.delete(id);
		return "ok";
	}

	@RequestMapping("/update")
	public Object update(City city) {
		cityService.update(city);
		return "ok";
	}
	
	@RequestMapping("/add")
	public Object add(City city) {
		cityService.update(city);
		return "ok";
	}
}
