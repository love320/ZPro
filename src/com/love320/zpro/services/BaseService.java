package com.love320.zpro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseService {
	
	@Autowired
	protected  JdbcTemplate jdbc;
	
	
	
	
}
