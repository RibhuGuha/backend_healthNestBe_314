package com.app.healthNestBe.repository;

import com.app.healthNestBe.model.SpecialtyCategory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class SpecialtyCategoryRepository extends SimpleJpaRepository<SpecialtyCategory, String> {
    private final EntityManager em;
    public SpecialtyCategoryRepository(EntityManager em) {
        super(SpecialtyCategory.class, em);
        this.em = em;
    }
    @Override
    public List<SpecialtyCategory> findAll() {
        return em.createNativeQuery("Select * from \"healthnestbe_986\".\"SpecialtyCategory\"", SpecialtyCategory.class).getResultList();
    }
}