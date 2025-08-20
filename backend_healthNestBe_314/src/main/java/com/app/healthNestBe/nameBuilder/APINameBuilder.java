package com.app.healthNestBe.nameBuilder;


import com.sap.olingo.jpa.metadata.core.edm.mapper.api.JPAEdmNameBuilder;
import com.sap.olingo.jpa.metadata.core.edm.mapper.impl.JPADefaultEdmNameBuilder;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EmbeddableType;
import javax.persistence.metamodel.EntityType;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Date;

public class APINameBuilder implements JPAEdmNameBuilder {
    private final JPAEdmNameBuilder defaultNameBuilder;

    public APINameBuilder(final String punit) {
        defaultNameBuilder = new JPADefaultEdmNameBuilder(punit);
    }

    @Override
    public String buildComplexTypeName(final EmbeddableType<?> jpaEmbeddedType) {
        return defaultNameBuilder.buildComplexTypeName(jpaEmbeddedType);
    }

    @Override
    public String buildContainerName() {
        return defaultNameBuilder.buildContainerName();
    }

    @Override
	public String buildEntitySetName(final String entityTypeName) {
    	String eSetName = null;
    	
    	eSetName = "Prescription".equals(entityTypeName) ? "Prescriptions" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Availability".equals(entityTypeName) ? "Availabilities" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Appointment".equals(entityTypeName) ? "Appointments" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Reminder".equals(entityTypeName) ? "Reminders" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "SpecialtyCategory".equals(entityTypeName) ? "SpecialtyCategories" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "ChatMessage".equals(entityTypeName) ? "ChatMessages" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Chatroom".equals(entityTypeName) ? "Chatrooms" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Patient".equals(entityTypeName) ? "Patients" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Doctor".equals(entityTypeName) ? "Doctors" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Review".equals(entityTypeName) ? "Reviews" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Document".equals(entityTypeName) ? "Documents" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Notification".equals(entityTypeName) ? "Notifications" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Specialty".equals(entityTypeName) ? "Specialties" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Clinic".equals(entityTypeName) ? "Clinics" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Weekday".equals(entityTypeName) ? "Weekdays" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Qualification".equals(entityTypeName) ? "Qualifications" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Payment".equals(entityTypeName) ? "Payments" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Medication".equals(entityTypeName) ? "Medications" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Slot".equals(entityTypeName) ? "Slots" : defaultNameBuilder.buildEntitySetName(entityTypeName);
        return eSetName;
    }

    @Override
    public String buildEntityTypeName(final EntityType<?> jpaEntityType) {
        return defaultNameBuilder.buildEntityTypeName(jpaEntityType);
    }

    @Override
    public String buildEnumerationTypeName(final Class<? extends Enum<?>> javaEnum) {
        return defaultNameBuilder.buildEnumerationTypeName(javaEnum);
    }

    @Override
    public String buildNaviPropertyName(final Attribute<?, ?> jpaAttribute) {
        return defaultNameBuilder.buildNaviPropertyName(jpaAttribute);
    }

    @Override
    public String buildOperationName(final String internalOperationName) {
        return defaultNameBuilder.buildOperationName(internalOperationName);
    }

    @Override
    public String buildPropertyName(final String jpaAttributeName) {
        return defaultNameBuilder.buildPropertyName(jpaAttributeName);
    }

    @Override
    public String getNamespace() {
        return defaultNameBuilder.getNamespace();
    }
}
