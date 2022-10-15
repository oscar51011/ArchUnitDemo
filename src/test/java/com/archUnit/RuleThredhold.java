package com.archUnit;

/**
 * 規則
 * @author oscar51011
 *
 */
public enum RuleThredhold {
	
	METHOD_MAX_PARAMETERS_SIZE(3),
	METHOD_MAX_LINES_SIZE(20);
	
	private int value;

	RuleThredhold(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
