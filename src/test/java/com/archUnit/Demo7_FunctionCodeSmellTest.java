package com.archUnit;

import java.util.List;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@AnalyzeClasses(packagesOf = ArchUnitDemoApplication.class)
public class Demo7_FunctionCodeSmellTest {
	
	
	/**
	 * Case7-1 , 規則: 實作 method 的參數 input 盡量要少於 4個
	 */
	@ArchTest
	ArchRule parametersMoreThenThree = ArchRuleDefinition.methods()
		.should(new ArchCondition<JavaMethod>("use less then four parameters"){
			@Override
			public void check(JavaMethod item, ConditionEvents events) {
				if(item.getParameters().size() > RuleThredhold.METHOD_MAX_PARAMETERS_SIZE.getValue()){
					// 新增違規項目
					events.add(SimpleConditionEvent.violated(events, 
							item.getDescription() + "'use parameters more then three' in " 
					        + item.getSourceCodeLocation()));
				}
			}	
	 	});
	 
	/**
	 * Case7-2 , 規則: 實作 method 的參數 不能使用 Boolean Object or boolean Primitive type
	 */
	@ArchTest
	ArchRule parameterCanNotUseFlagArgument = ArchRuleDefinition.methods()
		.should(notUseFlagArgumentParameter());

	private ArchCondition<JavaMethod> notUseFlagArgumentParameter() {
		return new ArchCondition<JavaMethod>("not use flag argments parameter"){
			@Override
			public void check(JavaMethod item, ConditionEvents events) {
				// 在有參數的情況下，檢查是否有 boolean or Boolean參數
				List<JavaClass> rawParameterTypes = item.getRawParameterTypes();
				if(rawParameterTypes.size() > 0) {
					for( JavaClass rawParameter : rawParameterTypes) {
						String parameterTypeName = rawParameter.getSimpleName();
						if(parameterTypeName.equals(Boolean.TYPE.getSimpleName())||
						   parameterTypeName.equals(Boolean.class.getSimpleName())) {
							// 新增違規項目
							events.add(SimpleConditionEvent.violated(events, 
										item.getDescription() + "'can not use " + parameterTypeName + " type' in " 
									    + item.getSourceCodeLocation()));
							break;
						}							
					}
				}
			}	
	 	};
	}
	
	/**
	 * Case7-3 , 規則: 計算 method 長度不可超過系統限制，避免可讀性差
	 */
	@ArchTest
	ArchRule codeLinesMoreThen20 = ArchRuleDefinition.methods()
		.should(notHaveCodeLinesMoreThen20());
	
	private ArchCondition<JavaMethod> notHaveCodeLinesMoreThen20() {
		return new ArchCondition<JavaMethod>("have less line numbers then" + RuleThredhold.METHOD_MAX_LINES_SIZE.getValue()){
			@Override
			public void check(JavaMethod item, ConditionEvents events) {
				// 讀取method起始行數
				int startLine = item.getSourceCodeLocation().getLineNumber();
				// 取得methodCall行數最大的資料當作最後一筆資料
				int endLine =item.getCallsFromSelf().stream().mapToInt(i -> i.getLineNumber()).max()
		          .orElse(startLine);
				int lines = endLine - startLine + 1;
				// 如果有回傳值(method type 不為 void)，要加上 retrun xxx 的那一行
				String returnType = item.getReturnType().getName();				
				if(!returnType.equals(void.class.getSimpleName())) lines = lines + 1;
				// 如果超過行數即新增違規項目
				if(lines > RuleThredhold.METHOD_MAX_LINES_SIZE.getValue()) {
					events.add(SimpleConditionEvent.violated(events, 
								item.getDescription() + "'code lines is " + lines + ".' in " 
					            + item.getSourceCodeLocation()));
				}
			}	
	 	};
	}
}
