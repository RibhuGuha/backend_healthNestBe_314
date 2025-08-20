package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.AppointmentStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class AppointmentStatusConverter implements AttributeConverter<AppointmentStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AppointmentStatus appointmentStatus) {
        return appointmentStatus != null ? appointmentStatus.ordinal() : null;
    }

    @Override
    public AppointmentStatus convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return AppointmentStatus.getAppointmentStatus(dbData);
    }
}
