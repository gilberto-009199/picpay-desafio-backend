package com.github.gilberto009199.picpay.enums;

public enum WalletEnum {
	common(1),
	seller(2);

	private int value;

	WalletEnum(int value) {
		this.value = value;
	}
	public void getValue(int value) {
		this.value = value;
	}
}
