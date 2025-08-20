package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.ReminderType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class ReminderTypeConverter implements AttributeConverter<ReminderType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ReminderType reminderType) {
        return reminderType != null ? reminderType.ordinal() : null;
    }

    @Override
    public ReminderType convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return ReminderType.getReminderType(dbData);
    }
}
