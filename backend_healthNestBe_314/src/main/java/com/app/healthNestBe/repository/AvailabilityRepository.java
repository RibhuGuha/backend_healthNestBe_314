package com.app.healthNestBe.repository;

import com.app.healthNestBe.model.Availability;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class AvailabilityRepository extends SimpleJpaRepository<Availability, String> {
    private final EntityManager em;
    public AvailabilityRepository(EntityManager em) {
        super(Availability.class, em);
        this.em = em;
    }
    @Override
    public List<Availability> findAll() {
        return em.createNativeQuery("Select * from \"healthnestbe_986\".\"Availability\"", Availability.class).getResultList();
    }
}