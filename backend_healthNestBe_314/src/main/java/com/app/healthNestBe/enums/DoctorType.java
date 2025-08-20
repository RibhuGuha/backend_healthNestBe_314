package com.app.healthNestBe.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum DoctorType{
	    GeneralPhysician,
	    Pediatrics,
	    Dermatology,
	    Psychiatry,
	    Psychology,
	    Gastroenterology,
	    Cardiology,
	    Neurology,
	    Gynecology,
	    Urology,
	    Orthopedics,
	    Endocrinology,
	    Pulmonology,
	    ENT,
	    Ophthalmology,
	    Dentistry,
	    Therapist/Counselor,
	    AddictionSpecialist,
	    SleepSpecialist,
	    Nutrition/Dietition,
	    FitnessConsultant,
	    ChronicPainSpecialist; 
    public int value(DoctorType doctorType) {
        return doctorType.ordinal();
    }
    public static DoctorType getDoctorType(int ordinal) {
        for(DoctorType doctorType : DoctorType.values())
                if(doctorType.ordinal() == ordinal)
                        return doctorType;
        return null;
    }
}


