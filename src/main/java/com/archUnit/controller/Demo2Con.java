package com.archUnit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Case2: DEMO class命名規則不符
 * @author oscar51011
 *
 */
@RestController
@RequestMapping("/demo")
public class Demo2Con {

	@RequestMapping("/demo2")
	public String demo() {
		return "case2: wrong class name demo";
	}
}
