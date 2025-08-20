package com.app.healthNestBe.model.complex;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class MedicalInformation {
  
	
  @Column(name = "\"KnownMedicalConditions\"", nullable = true)
  private String knownMedicalConditions;
	
  @Column(name = "\"Allergies\"", nullable = true)
  private String allergies;
	
  @Column(name = "\"Medications\"", nullable = true)
  private String medications;
	
  @Column(name = "\"FamilyMedicalHistory\"", nullable = true)
  private String familyMedicalHistory;
}
