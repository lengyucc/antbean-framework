package com.antbean.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.antbean.framework.dal.mapper.CityMapper;
import com.antbean.framework.domain.entity.City;
import com.antbean.framework.service.impl.ICityService;

@Service
public class CityServiceImpl implements ICityService {
	@Autowired
	CityMapper cityMapper;

	@Cacheable(value = "city", key = "#id")
	@Override
	public City get(Long id) {
		return cityMapper.selectByPrimaryKey(id);
	}

	@CacheEvict(value = "city", key = "#id")
	@Override
	public void delete(Long id) {
		cityMapper.deleteByPrimaryKey(id);
	}

	@CachePut(value = "city", key = "#city.id")
	@Override
	public void update(City city) {
		cityMapper.updateByPrimaryKey(city);
	}

	// 由于新增时id不存在，所有这个会出问题
//	@CachePut(value = "city", key = "#city.id")
	@Override
	public void save(City city) {
		cityMapper.insertUseGeneratedKeys(city);
	}

}
