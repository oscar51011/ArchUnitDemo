package com.archUnit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archUnit.dao.DemoDao;

/**
 * Case4: DEMO controller 跳過 service 直接呼叫 dao 的情境
 * @author oscar51011
 *
 */
@RestController
@RequestMapping("demo")
public class Demo4Controller {

	@Autowired
	private DemoDao dao;
	
	@RequestMapping("demo4")
	public String demo() {
		
		dao.getDemoString();
		
		return "case 4: wrong Layer demo";
	}
}
