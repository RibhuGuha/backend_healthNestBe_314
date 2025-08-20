package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum BeforeOrAfter{
	    Before,
	    After; 
    public int value(BeforeOrAfter beforeOrAfter) {
        return beforeOrAfter.ordinal();
    }
    public static BeforeOrAfter getBeforeOrAfter(int ordinal) {
        for(BeforeOrAfter beforeOrAfter : BeforeOrAfter.values())
                if(beforeOrAfter.ordinal() == ordinal)
                        return beforeOrAfter;
        return null;
    }
}


