package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.BookingType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class BookingTypeConverter implements AttributeConverter<BookingType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BookingType bookingType) {
        return bookingType != null ? bookingType.ordinal() : null;
    }

    @Override
    public BookingType convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return BookingType.getBookingType(dbData);
    }
}
