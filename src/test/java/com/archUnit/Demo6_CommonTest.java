package com.archUnit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

@AnalyzeClasses(packagesOf = ArchUnitDemoApplication.class)
public class Demo6_CommonTest {

     /**
      * 規則，專案不要拋出 EXCEPTION，請嚴格定義 EXCEPTION 的原因而非拋出最大的 EXCEPTION
      */
	 @ArchTest
	 ArchRule exceptionRule = GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
	 
	 /**
	  * 規則，不要使用 JAVA UTIL 類別的 LOGGING ( 專案已經有 lombok 的 SLF4J 套件 )
	  */
	 @ArchTest
	 ArchRule loggerRule = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
}
