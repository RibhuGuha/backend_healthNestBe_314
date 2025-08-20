package com.app.healthNestBe.model.complex;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class Address {
  
	
  @Column(name = "\"Address\"", nullable = true)
  private String address;
	
  @Column(name = "\"City\"", nullable = true)
  private String city;
	
  @Column(name = "\"State\"", nullable = true)
  private String state;
	
  @Column(name = "\"Country\"", nullable = true)
  private String country;
	
  @Column(name = "\"PostalCode\"", nullable = true)
  private Long postalCode;
}
