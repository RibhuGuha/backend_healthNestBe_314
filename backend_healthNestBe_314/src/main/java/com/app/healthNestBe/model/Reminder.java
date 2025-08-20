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

@Entity(name = "Reminder")
@Table(name = "\"Reminder\"", schema =  "\"healthnestbe_986\"")
@Data
                        
public class Reminder {
	public Reminder () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ReminderId\"", nullable = true )
  private Long reminderId;
	  
  @Column(name = "\"Message\"", nullable = true )
  private String message;
  
	  
  @Column(name = "\"RemindAt\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date remindAt;
  
	  
  @Column(name = "\"SentAt\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date sentAt;
  
	  
  @Column(name = "\"IsSent\"", nullable = true )
  private Boolean isSent;
  
	  
  @Column(name = "\"Type\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = ReminderTypeConverter.class)
  private ReminderType type;
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Reminder [" 
  + "ReminderId= " + reminderId  + ", " 
  + "Message= " + message  + ", " 
  + "RemindAt= " + remindAt  + ", " 
  + "SentAt= " + sentAt  + ", " 
  + "IsSent= " + isSent  + ", " 
  + "Type= " + type 
 + "]";
	}
	
}
