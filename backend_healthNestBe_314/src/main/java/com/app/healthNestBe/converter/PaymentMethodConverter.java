package com.app.healthNestBe.converter;

import com.app.healthNestBe.enums.PaymentMethod;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class PaymentMethodConverter implements AttributeConverter<PaymentMethod, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PaymentMethod paymentMethod) {
        return paymentMethod != null ? paymentMethod.ordinal() : null;
    }

    @Override
    public PaymentMethod convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return PaymentMethod.getPaymentMethod(dbData);
    }
}
