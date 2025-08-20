package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum PrescribedItemType{
	    Tablet,
	    Capsule,
	    Gel,
	    Ointment,
	    Others; 
    public int value(PrescribedItemType prescribedItemType) {
        return prescribedItemType.ordinal();
    }
    public static PrescribedItemType getPrescribedItemType(int ordinal) {
        for(PrescribedItemType prescribedItemType : PrescribedItemType.values())
                if(prescribedItemType.ordinal() == ordinal)
                        return prescribedItemType;
        return null;
    }
}


