package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.BookingStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class BookingStatusConverter implements AttributeConverter<BookingStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BookingStatus bookingStatus) {
        return bookingStatus != null ? bookingStatus.ordinal() : null;
    }

    @Override
    public BookingStatus convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return BookingStatus.getBookingStatus(dbData);
    }
}
