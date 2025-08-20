package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.PaymentStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PaymentStatus paymentStatus) {
        return paymentStatus != null ? paymentStatus.ordinal() : null;
    }

    @Override
    public PaymentStatus convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return PaymentStatus.getPaymentStatus(dbData);
    }
}
