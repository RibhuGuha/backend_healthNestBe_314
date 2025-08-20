fpackage com.app.healthNestBe.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.app.healthNestBe.model.Notification;
import com.app.healthNestBe.model.Qualification;
import com.app.healthNestBe.model.Slot;
import com.app.healthNestBe.model.Doctor;
import com.app.healthNestBe.model.Weekday;
import com.app.healthNestBe.model.Specialty;
import com.app.healthNestBe.model.Prescription;
import com.app.healthNestBe.model.Medication;
import com.app.healthNestBe.model.Reminder;
import com.app.healthNestBe.model.SpecialtyCategory;
import com.app.healthNestBe.model.Document;
import com.app.healthNestBe.model.Availability;
import com.app.healthNestBe.model.Chatroom;
import com.app.healthNestBe.model.Patient;
import com.app.healthNestBe.model.Review;
import com.app.healthNestBe.model.ChatMessage;
import com.app.healthNestBe.model.Clinic;
import com.app.healthNestBe.model.Appointment;
import com.app.healthNestBe.model.Payment;
import com.app.healthNestBe.model.complex.Vitals;
import com.app.healthNestBe.model.complex.MedicalInformation;
import com.app.healthNestBe.model.complex.Address;
import com.app.healthNestBe.enums.Gender;
import com.app.healthNestBe.enums.DoctorType;
import com.app.healthNestBe.enums.AppointmentStatus;
import com.app.healthNestBe.enums.PaymentStatus;
import com.app.healthNestBe.enums.NotificationType;
import com.app.healthNestBe.enums.PrescribedItemType;
import com.app.healthNestBe.enums.BookingStatus;
import com.app.healthNestBe.enums.BeforeOrAfter;
import com.app.healthNestBe.enums.ReminderType;
import com.app.healthNestBe.enums.Day;
import com.app.healthNestBe.enums.BookingType;
import com.app.healthNestBe.enums.PaymentMethod;
import com.app.healthNestBe.converter.BookingStatusConverter;
import com.app.healthNestBe.converter.PrescribedItemTypeConverter;
import com.app.healthNestBe.converter.PaymentMethodConverter;
import com.app.healthNestBe.converter.AppointmentStatusConverter;
import com.app.healthNestBe.converter.DayConverter;
import com.app.healthNestBe.converter.BookingTypeConverter;
import com.app.healthNestBe.converter.BeforeOrAfterConverter;
import com.app.healthNestBe.converter.ReminderTypeConverter;
import com.app.healthNestBe.converter.PaymentStatusConverter;
import com.app.healthNestBe.converter.GenderConverter;
import com.app.healthNestBe.converter.NotificationTypeConverter;
import com.app.healthNestBe.converter.DoctorTypeConverter;
import com.app.healthNestBe.converter.DurationConverter;
import com.app.healthNestBe.converter.UUIDToByteConverter;
import com.app.healthNestBe.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Doctor")
@Table(name = "\"Doctor\"", schema =  "\"healthnestbe_986\"")
@Data
                        
public class Doctor {
	public Doctor () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"DoctorId\"", nullable = true )
  private Long doctorId;
	  
  @Column(name = "\"FullName\"", nullable = true )
  private String fullName;
  
	  
  @Column(name = "\"Email\"", nullable = true )
  private String email;
  
	  
  @Column(name = "\"Gender\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = GenderConverter.class)
  private Gender gender;
  
	  
  @Column(name = "\"DateOfBirth\"", nullable = true )
  private LocalDate dateOfBirth;  
  
	  
  @Column(name = "\"PhoneNumber\"", nullable = true )
  private String phoneNumber;
  
	  
  @Column(name = "\"Title\"", nullable = true )
  private String title;
  
	  
  @Column(name = "\"Experience\"", nullable = true )
  private String experience;
  
	  
  @Column(name = "\"ConsultationFee\"", nullable = true )
  private Double consultationFee;
  
	  
  @Column(name = "\"Type\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = DoctorTypeConverter.class)
  private DoctorType type;
  
	  
  @Column(name = "\"IsApprovedByClinic\"", nullable = true )
  private Boolean isApprovedByClinic;
  
	  
  @Column(name = "\"ReviewCount\"", nullable = true )
  private Integer reviewCount;
  
	  
  @Column(name = "\"OverallRating\"", nullable = true )
  private Integer overallRating;
  
	  
  @Column(name = "\"IsWeekly\"", nullable = true )
  private Boolean isWeekly;
  
	  
  @Column(name = "\"DateOfJoining\"", nullable = true )
  private LocalDate dateOfJoining;  
  
	  
  @Embedded
  @Column(name = "\"Address\"")
  @AttributeOverrides({
            	@AttributeOverride(name = "address", column = @Column(name = "\"Address_Address\"")) ,
            	@AttributeOverride(name = "city", column = @Column(name = "\"Address_City\"")) ,
            	@AttributeOverride(name = "state", column = @Column(name = "\"Address_State\"")) ,
            	@AttributeOverride(name = "country", column = @Column(name = "\"Address_Country\"")) ,
            	@AttributeOverride(name = "postalCode", column = @Column(name = "\"Address_PostalCode\""))  }) 
  private Address address;
  
	  
  @Column(name = "\"About\"", nullable = true )
  private String about;
  
  
  
  
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"DoctorDoctorImage\"", referencedColumnName = "\"DocId\"", insertable = false, updatable = false)
	private Document doctorImage;
	
	@Column(name = "\"DoctorDoctorImage\"")
	private Long doctorDoctorImage;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"DoctorSpeciality\"", referencedColumnName = "\"DocSpeId\"", insertable = false, updatable = false)
	private Specialty speciality;
	
	@Column(name = "\"DoctorSpeciality\"")
	private Long doctorSpeciality;
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"DoctorQualifications\"",
            joinColumns = @JoinColumn( name="\"DoctorId\""),
            inverseJoinColumns = @JoinColumn( name="\"QualificationId\""), schema = "\"healthnestbe_986\"")
private List<Qualification> qualifications = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"DoctorPatientAppointments\"",
            joinColumns = @JoinColumn( name="\"DoctorId\""),
            inverseJoinColumns = @JoinColumn( name="\"AppointmentId\""), schema = "\"healthnestbe_986\"")
private List<Appointment> patientAppointments = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"DoctorAvailabilities\"",
            joinColumns = @JoinColumn( name="\"DoctorId\""),
            inverseJoinColumns = @JoinColumn( name="\"SlotId\""), schema = "\"healthnestbe_986\"")
private List<Slot> availabilities = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"DoctorPayments\"",
            joinColumns = @JoinColumn( name="\"DoctorId\""),
            inverseJoinColumns = @JoinColumn( name="\"PaymentId\""), schema = "\"healthnestbe_986\"")
private List<Payment> payments = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"DoctorDoctorChatrooms\"",
            joinColumns = @JoinColumn( name="\"DoctorId\""),
            inverseJoinColumns = @JoinColumn( name="\"ChatroomId\""), schema = "\"healthnestbe_986\"")
private List<Chatroom> doctorChatrooms = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"DoctorCertifications\"",
            joinColumns = @JoinColumn( name="\"DoctorId\""),
            inverseJoinColumns = @JoinColumn( name="\"DocId\""), schema = "\"healthnestbe_986\"")
private List<Document> certifications = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"DoctorWeeklyScheduleByDays\"",
            joinColumns = @JoinColumn( name="\"DoctorId\""),
            inverseJoinColumns = @JoinColumn( name="\"WeekdayId\""), schema = "\"healthnestbe_986\"")
private List<Weekday> weeklyScheduleByDays = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Doctor [" 
  + "DoctorId= " + doctorId  + ", " 
  + "FullName= " + fullName  + ", " 
  + "Email= " + email  + ", " 
  + "Gender= " + gender  + ", " 
  + "DateOfBirth= " + dateOfBirth  + ", " 
  + "PhoneNumber= " + phoneNumber  + ", " 
  + "Title= " + title  + ", " 
  + "Experience= " + experience  + ", " 
  + "ConsultationFee= " + consultationFee  + ", " 
  + "Type= " + type  + ", " 
  + "IsApprovedByClinic= " + isApprovedByClinic  + ", " 
  + "ReviewCount= " + reviewCount  + ", " 
  + "OverallRating= " + overallRating  + ", " 
  + "IsWeekly= " + isWeekly  + ", " 
  + "DateOfJoining= " + dateOfJoining  + ", " 
  + "Address= " + address  + ", " 
  + "About= " + about 
 + "]";
	}
	
}
