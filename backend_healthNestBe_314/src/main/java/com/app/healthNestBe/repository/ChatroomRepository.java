package com.app.healthNestBe.repository;

import com.app.healthNestBe.model.Chatroom;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ChatroomRepository extends SimpleJpaRepository<Chatroom, String> {
    private final EntityManager em;
    public ChatroomRepository(EntityManager em) {
        super(Chatroom.class, em);
        this.em = em;
    }
    @Override
    public List<Chatroom> findAll() {
        return em.createNativeQuery("Select * from \"healthnestbe_986\".\"Chatroom\"", Chatroom.class).getResultList();
    }
}