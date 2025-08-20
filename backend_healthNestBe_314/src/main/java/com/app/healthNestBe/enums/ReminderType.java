package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum ReminderType{
	    Appointment,
	    FollowUp,
	    PaymentDue; 
    public int value(ReminderType reminderType) {
        return reminderType.ordinal();
    }
    public static ReminderType getReminderType(int ordinal) {
        for(ReminderType reminderType : ReminderType.values())
                if(reminderType.ordinal() == ordinal)
                        return reminderType;
        return null;
    }
}


