package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.DoctorType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class DoctorTypeConverter implements AttributeConverter<DoctorType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DoctorType doctorType) {
        return doctorType != null ? doctorType.ordinal() : null;
    }

    @Override
    public DoctorType convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return DoctorType.getDoctorType(dbData);
    }
}
