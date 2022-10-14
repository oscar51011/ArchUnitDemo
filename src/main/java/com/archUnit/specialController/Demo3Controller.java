package com.archUnit.specialController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Case3: DEMO Controller 放到非統一定義的資料夾
 * => 此情境會有問題的原因是程式有同一使用AOP，如果沒有按照規則會無法被AOP規則找到
 * @author oscar51011
 *
 */
@RestController
@RequestMapping("demo")
public class Demo3Controller {
	@RequestMapping("demo3")
	public String demo1() {
		return "case3: wrong package place demo";
	}
}
