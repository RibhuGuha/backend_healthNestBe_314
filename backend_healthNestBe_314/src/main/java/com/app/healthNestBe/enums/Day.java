package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum Day{
	    Sunday,
	    Monday,
	    Tuesday,
	    Wednesday,
	    Thursday,
	    Friday,
	    Saturday; 
    public int value(Day day) {
        return day.ordinal();
    }
    public static Day getDay(int ordinal) {
        for(Day day : Day.values())
                if(day.ordinal() == ordinal)
                        return day;
        return null;
    }
}


