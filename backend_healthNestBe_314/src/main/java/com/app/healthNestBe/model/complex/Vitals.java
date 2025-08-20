package com.app.healthNestBe.model.complex;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class Vitals {
  
	
  @Column(name = "\"BodyTemperature\"", nullable = true)
  private String bodyTemperature;
	
  @Column(name = "\"BloodPressure\"", nullable = true)
  private String bloodPressure;
	
  @Column(name = "\"OxygenSaturation\"", nullable = true)
  private String oxygenSaturation;
	
  @Column(name = "\"Height\"", nullable = true)
  private String height;
	
  @Column(name = "\"BloodGlucose\"", nullable = true)
  private String bloodGlucose;
	
  @Column(name = "\"HeartRate\"", nullable = true)
  private String heartRate;
	
  @Column(name = "\"RespiratoryRate\"", nullable = true)
  private String respiratoryRate;
	
  @Column(name = "\"Weight\"", nullable = true)
  private String weight;
	
  @Column(name = "\"BodyMassIndex\"", nullable = true)
  private String bodyMassIndex;
}
