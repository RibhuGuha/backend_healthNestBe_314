package com.app.healthNestBe.integrationtest;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.app.healthNestBe.SpringApp;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "spring.config.location=classpath:application-test.yml" })
class ControllerTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private final ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private WebApplicationContext context;
  @LocalServerPort
  private int port;

  @BeforeEach
  void setup() {
    RestAssuredMockMvc.webAppContextSetup(context);
  }

  
  
   private JsonNode getJSONFromFile(String filePath) throws IOException {
    try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)){
      JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
      return jsonNode;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  
  private String getPayload(String filePath) throws IOException {
	  String jsonString = mapper.writeValueAsString( getJSONFromFile(filePath) );
	  return jsonString;
  }

  @Test
  void testRetrieveServiceDocument() {
    final String xml = given()
        .accept(ContentType.XML)
        .when()
        .get("/healthNestBe/")
        .then()
        .statusCode(HttpStatusCode.OK.getStatusCode())
        .contentType(ContentType.XML)
        .extract()
        .asString();

    final XmlPath path = new XmlPath(xml);
    final Collection<Node> n = ((Node) ((Node) path.get("service")).get("workspace")).get("collection");
    assertNotNull(n);
    assertFalse(n.isEmpty());
  }

  @Test
  void  testRetrieveMetadataDocument() {
    final String xml = given()
        .when()
        .get("/healthNestBe/$metadata")
        .then()
        .statusCode(HttpStatusCode.OK.getStatusCode())
        .contentType(ContentType.XML)
        .extract()
        .asString();

    final XmlPath path = new XmlPath(xml);
    final Node n = ((Node) ((Node) path.get("edmx:Ed mx")).get("DataServices")).get("Schema");
    assertNotNull(n);
    assertEquals("healthNestBe", n.getAttribute("Namespace"));
    assertNotNull(n.get("EntityContainer"));
  }

	

	
  @Test
  void  testCreatePrescriptionInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("PrescriptionInstance.json"))
        .when()
        .post("/healthNestBe/Prescriptions")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsPrescription() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("PrescriptionInstance.json"))
        .when()
        .post("/healthNestBe/Prescriptions")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Prescriptions?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).PrescriptionId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Prescriptions/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateAvailabilityInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("AvailabilityInstance.json"))
        .when()
        .post("/healthNestBe/Availabilities")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsAvailability() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("AvailabilityInstance.json"))
        .when()
        .post("/healthNestBe/Availabilities")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Availabilities?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).AvailabiltyId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Availabilities/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateAppointmentInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("AppointmentInstance.json"))
        .when()
        .post("/healthNestBe/Appointments")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsAppointment() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("AppointmentInstance.json"))
        .when()
        .post("/healthNestBe/Appointments")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Appointments?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).AppointmentId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Appointments/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateReminderInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ReminderInstance.json"))
        .when()
        .post("/healthNestBe/Reminders")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsReminder() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ReminderInstance.json"))
        .when()
        .post("/healthNestBe/Reminders")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Reminders?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ReminderId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Reminders/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateSpecialtyCategoryInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("SpecialtyCategoryInstance.json"))
        .when()
        .post("/healthNestBe/SpecialtyCategories")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsSpecialtyCategory() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("SpecialtyCategoryInstance.json"))
        .when()
        .post("/healthNestBe/SpecialtyCategories")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/SpecialtyCategories?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).Name", equalTo("'<<replace_with_keyFieldValue>>'"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/SpecialtyCategories/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateChatMessageInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ChatMessageInstance.json"))
        .when()
        .post("/healthNestBe/ChatMessages")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsChatMessage() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ChatMessageInstance.json"))
        .when()
        .post("/healthNestBe/ChatMessages")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/ChatMessages?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ChatMessageId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/ChatMessages/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateChatroomInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ChatroomInstance.json"))
        .when()
        .post("/healthNestBe/Chatrooms")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsChatroom() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ChatroomInstance.json"))
        .when()
        .post("/healthNestBe/Chatrooms")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Chatrooms?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ChatroomId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Chatrooms/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreatePatientInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("PatientInstance.json"))
        .when()
        .post("/healthNestBe/Patients")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsPatient() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("PatientInstance.json"))
        .when()
        .post("/healthNestBe/Patients")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Patients?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).PatientId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Patients/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateDoctorInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("DoctorInstance.json"))
        .when()
        .post("/healthNestBe/Doctors")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsDoctor() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("DoctorInstance.json"))
        .when()
        .post("/healthNestBe/Doctors")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Doctors?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).DoctorId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Doctors/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateReviewInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ReviewInstance.json"))
        .when()
        .post("/healthNestBe/Reviews")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsReview() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ReviewInstance.json"))
        .when()
        .post("/healthNestBe/Reviews")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Reviews?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ReviewId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Reviews/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateDocumentInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("DocumentInstance.json"))
        .when()
        .post("/healthNestBe/Documents")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsDocument() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("DocumentInstance.json"))
        .when()
        .post("/healthNestBe/Documents")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Documents?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).DocId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Documents/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateNotificationInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("NotificationInstance.json"))
        .when()
        .post("/healthNestBe/Notifications")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsNotification() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("NotificationInstance.json"))
        .when()
        .post("/healthNestBe/Notifications")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Notifications?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).NotificationId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Notifications/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateSpecialtyInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("SpecialtyInstance.json"))
        .when()
        .post("/healthNestBe/Specialties")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsSpecialty() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("SpecialtyInstance.json"))
        .when()
        .post("/healthNestBe/Specialties")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Specialties?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).DocSpeId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Specialties/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateClinicInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("ClinicInstance.json"))
        .when()
        .post("/healthNestBe/Clinics")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsClinic() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("ClinicInstance.json"))
        .when()
        .post("/healthNestBe/Clinics")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Clinics?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ClinicId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Clinics/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateWeekdayInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("WeekdayInstance.json"))
        .when()
        .post("/healthNestBe/Weekdays")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsWeekday() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("WeekdayInstance.json"))
        .when()
        .post("/healthNestBe/Weekdays")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Weekdays?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).WeekdayId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Weekdays/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateQualificationInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("QualificationInstance.json"))
        .when()
        .post("/healthNestBe/Qualifications")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsQualification() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("QualificationInstance.json"))
        .when()
        .post("/healthNestBe/Qualifications")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Qualifications?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).QualificationId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Qualifications/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreatePaymentInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("PaymentInstance.json"))
        .when()
        .post("/healthNestBe/Payments")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsPayment() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("PaymentInstance.json"))
        .when()
        .post("/healthNestBe/Payments")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Payments?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).PaymentId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Payments/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateMedicationInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("MedicationInstance.json"))
        .when()
        .post("/healthNestBe/Medications")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsMedication() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("MedicationInstance.json"))
        .when()
        .post("/healthNestBe/Medications")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Medications?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).MedicationId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Medications/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateSlotInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("SlotInstance.json"))
        .when()
        .post("/healthNestBe/Slots")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsSlot() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("SlotInstance.json"))
        .when()
        .post("/healthNestBe/Slots")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/healthNestBe/Slots?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).SlotId", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/healthNestBe/Slots/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
           
       
  
  
  
  
 
  @AfterEach
  void  teardown() {
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Prescription");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Availability");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Appointment");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Reminder");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.SpecialtyCategory");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.ChatMessage");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Chatroom");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Patient");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Doctor");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Review");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Document");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Notification");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Specialty");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Clinic");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Weekday");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Qualification");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Payment");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Medication");
    jdbcTemplate.execute("DELETE FROM healthnestbe_986.Slot");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.DoctorPatientAppointments");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.DoctorAvailabilities");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.DoctorCertifications");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.AppointmentDocuments");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.DoctorDoctorChatrooms");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.DoctorWeeklyScheduleByDays");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.DoctorPayments");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.DoctorQualifications");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.AppointmentReminders");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.PrescriptionMeds");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.ClinicDoctors");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.PatientAppointments");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.SpecialtyAvailableDocs");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.AvailabilitySlots");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.ChatroomChats");
     jdbcTemplate.execute("DELETE FROM healthnestbe_986.PatientChatrooms");

    RestAssuredMockMvc.reset();
  }
}
