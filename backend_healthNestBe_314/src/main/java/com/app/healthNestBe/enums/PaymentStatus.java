package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum PaymentStatus{
	    Completed,
	    Failed,
	    Pending; 
    public int value(PaymentStatus paymentStatus) {
        return paymentStatus.ordinal();
    }
    public static PaymentStatus getPaymentStatus(int ordinal) {
        for(PaymentStatus paymentStatus : PaymentStatus.values())
                if(paymentStatus.ordinal() == ordinal)
                        return paymentStatus;
        return null;
    }
}


