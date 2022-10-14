package com.archUnit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packagesOf = ArchUnitDemoApplication.class)
public class Demo3_WrongPackageTest {

	/**
	 * 規則，當命名為 xxxController 時，需要把 class 放在對應的 package底下 ( com.archUnit.controller )
	 */
	@ArchTest
    ArchRule rule = ArchRuleDefinition.classes()
            .that().haveSimpleNameEndingWith("Controller")
            .should().resideInAPackage("com.archUnit.controller");
}
