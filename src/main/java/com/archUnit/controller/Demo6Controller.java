package com.archUnit.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archUnit.service.DemoService;

import lombok.extern.slf4j.Slf4j;

/**
 * Case6: DEMO 呼叫 服務拋出 最大 Exception 的情境 ( 應該定義清楚的錯誤，而非用最大的 Exception )
 * @author oscar51011
 *
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class Demo6Controller {
	
	Logger logger = Logger.getLogger(Demo6Controller.class.getName());
	
	@Autowired
	private DemoService service;

	@RequestMapping("demo6")
	public String demo() throws Exception {
		logger.info("test java.util.logger");
		service.demoExceptionService(-1);
		return "case 6: wrong Layer demo";
	}
	
	@RequestMapping("demo6-2")
	public String demoLogger() throws Exception {
		log.info("use SLF4J log message");
		logger.info("use java.util.logger message");
		return "case 6-2: wrong Logger library";
	}
}
