package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.Day;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class DayConverter implements AttributeConverter<Day, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Day day) {
        return day != null ? day.ordinal() : null;
    }

    @Override
    public Day convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return Day.getDay(dbData);
    }
}
