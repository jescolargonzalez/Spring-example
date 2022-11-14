package com.example.spring.dao;

import com.example.spring.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getUsuarios() {
        String query = "FROM User";
        return em.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        User user = em.find(User.class , id);
        em.remove(user);
    }

    @Override
    public void newUser(User user) {
        em.merge(user);
    }
}
