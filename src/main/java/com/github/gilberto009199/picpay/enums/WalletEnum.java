package com.github.gilberto009199.picpay.enums;

public enum WalletEnum {
	common(1),
	seller(2);

	private final int value;

	WalletEnum(int value) {
		this.value = value;
	}
	public int getValue() { return this.value;	}
    public static WalletEnum fromValue(int value) {
        for (WalletEnum walletEnum : WalletEnum.values()) {
            if (walletEnum.getValue() == value) {
                return walletEnum;
            }
        }
        throw new IllegalArgumentException("Valor inválido para WalletEnum: " + value);
    }
}
