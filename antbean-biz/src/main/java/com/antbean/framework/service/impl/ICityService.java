package com.antbean.framework.service.impl;

import com.antbean.framework.domain.entity.City;

public interface ICityService {
	City get(Long id);

	void update(City city);

	void save(City city);

	void delete(Long id);
}
