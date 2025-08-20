package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum PaymentMethod{
	    Card,
	    UPI,
	    Wallet,
	    Netbanking; 
    public int value(PaymentMethod paymentMethod) {
        return paymentMethod.ordinal();
    }
    public static PaymentMethod getPaymentMethod(int ordinal) {
        for(PaymentMethod paymentMethod : PaymentMethod.values())
                if(paymentMethod.ordinal() == ordinal)
                        return paymentMethod;
        return null;
    }
}


