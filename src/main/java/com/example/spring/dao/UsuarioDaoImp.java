package com.example.spring.dao;

import com.example.spring.model.User;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public User obtenerUserPorCredenciales(User user){
        String query = " FROM User WHERE email = :email ";
        List<User> lista = em.createQuery(query)
                .setParameter("email",user.getEmail())
                .getResultList();

        if(lista.isEmpty()){
            return null;
        }

        String pwdHash = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(pwdHash,user.getPassword())){
            return lista.get(0);
        }
        return null;
    }



}
