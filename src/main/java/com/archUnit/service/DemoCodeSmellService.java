package com.archUnit.service;

/**
 * 用來演練 程式壞味道的 service
 * @author oscar51011
 *
 */
public class DemoCodeSmellService {
		
	/**
	 * Case 7-1:
	 * 用來演練一個 method 傳入的參數超過3個，應該包成一個 class 來標明其意義
	 * Clean Code - Ch17 (Function 1) 過多的參數
	 * @return
	 */
	public boolean demoMethodParametersLargerThenThree(int a,int b, int c,int d) {
		return true;
	}
	
	/**
	 * Case 7-2:
	 * 用來演練一個 method 避免傳入 Flag Arguments ( Boolean Object )
	 * Clean Code - Ch17 (Function 3) 避免旗標參數
	 * @return
	 */
	public boolean demoMethodCanNotUseBooleanObjectType(int a,Boolean b) {
		return true;
	}
	
	/**
	 * Case 7-2:
	 * 用來演練一個 method 避免傳入 Flag Arguments( boolean Primitive Type )
	 * Clean Code - Ch17 (Function 3) 避免旗標參數
	 * @return
	 */
	public boolean demoMethodCanNotUseBooleanPrimitiveType(int a,boolean b) {
		return true;
	}
	
	/**
	 * Case 7-3:
	 * 用來演練一個 method 長度超過 20 行
	 * Clean Code - Ch3 P40 函式長度盡量要簡短
	 * @return
	 */
	public boolean demoMethodMaxLineMoreThen20() {
		System.out.println("Line 1");
		System.out.println("Line 2");
		System.out.println("Line 3");
		System.out.println("Line 4");
		System.out.println("Line 5");
		System.out.println("Line 6");
		System.out.println("Line 9");
		System.out.println("Line 8");
		System.out.println("Line 9");
		System.out.println("Line 10");
		System.out.println("Line 11");
		System.out.println("Line 12");
		System.out.println("Line 13");
		System.out.println("Line 14");
		System.out.println("Line 15");
		System.out.println("Line 16");
		System.out.println("Line 19");
		System.out.println("Line 18");
		System.out.println("Line 19");
		System.out.println("Line 20");
		System.out.println("Line 21");
		System.out.println("Line 22");
		System.out.println("Line 23");
		System.out.println("Line 24");
		System.out.println("Line 25");
		return true;
	}
}
