package com.app.healthNestBe.repository;

import com.app.healthNestBe.model.Specialty;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class SpecialtyRepository extends SimpleJpaRepository<Specialty, String> {
    private final EntityManager em;
    public SpecialtyRepository(EntityManager em) {
        super(Specialty.class, em);
        this.em = em;
    }
    @Override
    public List<Specialty> findAll() {
        return em.createNativeQuery("Select * from \"healthnestbe_986\".\"Specialty\"", Specialty.class).getResultList();
    }
}