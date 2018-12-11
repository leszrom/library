package com.crud.library.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute != null) {
            if (attribute) {
                return "Yes";
            } else {
                return "No";
            }
        }
        return null;
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if (dbData != null) {
            return dbData.equals("Yes");
        }
        return null;
    }
}
