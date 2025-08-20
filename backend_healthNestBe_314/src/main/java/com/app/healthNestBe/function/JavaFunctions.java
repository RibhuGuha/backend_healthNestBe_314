package com.app.healthNestBe.function;

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
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataFunction;
import com.app.healthNestBe.repository.PrescriptionRepository;
import com.app.healthNestBe.repository.AvailabilityRepository;
import com.app.healthNestBe.repository.AppointmentRepository;
import com.app.healthNestBe.repository.ReminderRepository;
import com.app.healthNestBe.repository.SpecialtyCategoryRepository;
import com.app.healthNestBe.repository.ChatMessageRepository;
import com.app.healthNestBe.repository.ChatroomRepository;
import com.app.healthNestBe.repository.PatientRepository;
import com.app.healthNestBe.repository.DoctorRepository;
import com.app.healthNestBe.repository.ReviewRepository;
import com.app.healthNestBe.repository.DocumentRepository;
import com.app.healthNestBe.repository.NotificationRepository;
import com.app.healthNestBe.repository.SpecialtyRepository;
import com.app.healthNestBe.repository.ClinicRepository;
import com.app.healthNestBe.repository.WeekdayRepository;
import com.app.healthNestBe.repository.QualificationRepository;
import com.app.healthNestBe.repository.PaymentRepository;
import com.app.healthNestBe.repository.MedicationRepository;
import com.app.healthNestBe.repository.SlotRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class JavaFunctions implements ODataFunction {


    
    
}
   
