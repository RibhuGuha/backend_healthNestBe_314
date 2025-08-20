package com.app.healthNestBe.repository;

import com.app.healthNestBe.model.Qualification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class QualificationRepository extends SimpleJpaRepository<Qualification, String> {
    private final EntityManager em;
    public QualificationRepository(EntityManager em) {
        super(Qualification.class, em);
        this.em = em;
    }
    @Override
    public List<Qualification> findAll() {
        return em.createNativeQuery("Select * from \"healthnestbe_986\".\"Qualification\"", Qualification.class).getResultList();
    }
}