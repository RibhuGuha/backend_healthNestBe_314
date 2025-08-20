package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.PrescribedItemType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class PrescribedItemTypeConverter implements AttributeConverter<PrescribedItemType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PrescribedItemType prescribedItemType) {
        return prescribedItemType != null ? prescribedItemType.ordinal() : null;
    }

    @Override
    public PrescribedItemType convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return PrescribedItemType.getPrescribedItemType(dbData);
    }
}
