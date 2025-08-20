package com.app.healthNestBe.repository;

import com.app.healthNestBe.model.Review;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ReviewRepository extends SimpleJpaRepository<Review, String> {
    private final EntityManager em;
    public ReviewRepository(EntityManager em) {
        super(Review.class, em);
        this.em = em;
    }
    @Override
    public List<Review> findAll() {
        return em.createNativeQuery("Select * from \"healthnestbe_986\".\"Review\"", Review.class).getResultList();
    }
}