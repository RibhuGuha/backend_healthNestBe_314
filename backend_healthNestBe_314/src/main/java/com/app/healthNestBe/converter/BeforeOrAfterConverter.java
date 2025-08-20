package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.BeforeOrAfter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class BeforeOrAfterConverter implements AttributeConverter<BeforeOrAfter, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BeforeOrAfter beforeOrAfter) {
        return beforeOrAfter != null ? beforeOrAfter.ordinal() : null;
    }

    @Override
    public BeforeOrAfter convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return BeforeOrAfter.getBeforeOrAfter(dbData);
    }
}
