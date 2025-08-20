package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum BookingStatus{
	    Pending,
	    Booked,
	    Cancelled; 
    public int value(BookingStatus bookingStatus) {
        return bookingStatus.ordinal();
    }
    public static BookingStatus getBookingStatus(int ordinal) {
        for(BookingStatus bookingStatus : BookingStatus.values())
                if(bookingStatus.ordinal() == ordinal)
                        return bookingStatus;
        return null;
    }
}


