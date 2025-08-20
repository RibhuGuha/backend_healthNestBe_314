package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum BookingType{
	    Weekly,
	    SpecificDate; 
    public int value(BookingType bookingType) {
        return bookingType.ordinal();
    }
    public static BookingType getBookingType(int ordinal) {
        for(BookingType bookingType : BookingType.values())
                if(bookingType.ordinal() == ordinal)
                        return bookingType;
        return null;
    }
}


