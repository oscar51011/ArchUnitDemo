package com.archUnit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packagesOf = ArchUnitDemoApplication.class)
public class Demo2_NamingTest {
	
	/**
	 * 規則，當class在 controller package 底下時，命名原則結尾需要為 Controller
	 * Example : xxxController
	 */
	@ArchTest
    ArchRule rule = ArchRuleDefinition.classes()
            .that().resideInAPackage("..controller..")
            .should().haveSimpleNameEndingWith("Controller");
	
}
