package com.archUnit;

import org.springframework.transaction.annotation.Transactional;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packagesOf = ArchUnitDemoApplication.class)
public class Demo5_RegulateClassLevelTransactionalAnnotationTest {

	/**
	 * 規則，當 service package 底下的服務，其 class level 不能定義 @Transactional 的 annotation
	 */
	@ArchTest
    ArchRule rule = ArchRuleDefinition.classes()
            .that().resideInAPackage("..service..")
            .should().notBeAnnotatedWith(Transactional.class);
}
