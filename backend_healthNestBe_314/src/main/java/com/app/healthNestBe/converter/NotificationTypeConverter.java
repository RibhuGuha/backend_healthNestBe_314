package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.NotificationType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class NotificationTypeConverter implements AttributeConverter<NotificationType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(NotificationType notificationType) {
        return notificationType != null ? notificationType.ordinal() : null;
    }

    @Override
    public NotificationType convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return NotificationType.getNotificationType(dbData);
    }
}
