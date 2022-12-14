package com.example.spring.dao;

import com.example.spring.model.User;

import java.util.List;

public interface UsuarioDao {
    List<User> getUsuarios();

    void eliminar(Long id);
    void newUser(User user);

    User obtenerUserPorCredenciales(User user);
}
