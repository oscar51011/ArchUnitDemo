package com.archUnit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.freeze.FreezingArchRule;

@AnalyzeClasses(packagesOf = ArchUnitDemoApplication.class)
public class Demo0_FreezeArchRuleTest {

	/**
	 * 規則: 新加入的 class 都必須在 archUnit package之外，當首次啟動時，會在 src/test/resources/freezeRepo
	 *     底下產生 rules 清單，且該次不符的清單都不會被加入違規事項，只有後續新加入的 class 會被此規則限制
	 */
	@ArchTest
	ArchRule rule= FreezingArchRule.freeze(
			ArchRuleDefinition.classes()
			.should().resideOutsideOfPackages("..archUnit..")
    );
}
