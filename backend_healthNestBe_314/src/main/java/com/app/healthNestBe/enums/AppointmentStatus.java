package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum AppointmentStatus{
	    Completed,
	    Pending,
	    Cancelled,
	    Rescheduled; 
    public int value(AppointmentStatus appointmentStatus) {
        return appointmentStatus.ordinal();
    }
    public static AppointmentStatus getAppointmentStatus(int ordinal) {
        for(AppointmentStatus appointmentStatus : AppointmentStatus.values())
                if(appointmentStatus.ordinal() == ordinal)
                        return appointmentStatus;
        return null;
    }
}


