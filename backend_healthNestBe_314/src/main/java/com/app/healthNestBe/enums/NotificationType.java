package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum NotificationType{
	    Chat,
	    Reminder,
	    Appointment,
	    Payment; 
    public int value(NotificationType notificationType) {
        return notificationType.ordinal();
    }
    public static NotificationType getNotificationType(int ordinal) {
        for(NotificationType notificationType : NotificationType.values())
                if(notificationType.ordinal() == ordinal)
                        return notificationType;
        return null;
    }
}


