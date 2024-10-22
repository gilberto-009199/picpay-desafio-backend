package com.github.gilberto009199.picpay.converters;
import com.github.gilberto009199.picpay.enums.WalletEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class WalletEnumConverter implements AttributeConverter<WalletEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(WalletEnum walletEnum) {
        if (walletEnum == null) {
            return null;
        }
        return walletEnum.getValue();
    }

    @Override
    public WalletEnum convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return WalletEnum.fromValue(dbData);
    }
}
