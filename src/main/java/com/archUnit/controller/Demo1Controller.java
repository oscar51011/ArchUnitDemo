package com.archUnit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archUnit.service.DemoService;

/**
 * Case1: DEMO正常情境
 * @author oscar51011
 *
 */
@RestController
@RequestMapping("demo")
public class Demo1Controller {

	@Autowired
	private DemoService service;
	
	@RequestMapping("demo1")
	public String demo() {
		
		service.demoService();
		
		return "case 1 demo";
	}
}
