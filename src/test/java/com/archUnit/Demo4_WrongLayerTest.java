package com.archUnit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packagesOf = ArchUnitDemoApplication.class)
public class Demo4_WrongLayerTest {

	/**
	 * 規則，依賴的順序為 dao 依賴 service 依賴 controller
	 * ※ controller層 不能被其他層呼叫
	 * ※ dao層 只能被 service層 呼叫
	 */
	@ArchTest
    ArchRule rule = Architectures.layeredArchitecture()
		    		.consideringAllDependencies()
		    	    .layer("Controller").definedBy("..controller..")
		    	    .layer("Service").definedBy("..service..")
		    	    .layer("Dao").definedBy("..dao..")
		    	    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
		    	    .whereLayer("Dao").mayOnlyBeAccessedByLayers("Service");
	
	
}
