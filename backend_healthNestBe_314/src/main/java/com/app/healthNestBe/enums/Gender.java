package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum Gender{
	    Male,
	    Female,
	    Others; 
    public int value(Gender gender) {
        return gender.ordinal();
    }
    public static Gender getGender(int ordinal) {
        for(Gender gender : Gender.values())
                if(gender.ordinal() == ordinal)
                        return gender;
        return null;
    }
}


