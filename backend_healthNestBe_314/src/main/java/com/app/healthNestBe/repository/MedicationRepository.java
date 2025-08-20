package com.app.healthNestBe.repository;

import com.app.healthNestBe.model.Medication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class MedicationRepository extends SimpleJpaRepository<Medication, String> {
    private final EntityManager em;
    public MedicationRepository(EntityManager em) {
        super(Medication.class, em);
        this.em = em;
    }
    @Override
    public List<Medication> findAll() {
        return em.createNativeQuery("Select * from \"healthnestbe_986\".\"Medication\"", Medication.class).getResultList();
    }
}