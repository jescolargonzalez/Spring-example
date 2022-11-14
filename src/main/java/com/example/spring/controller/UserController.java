package com.example.spring.controller;

import com.example.spring.dao.UsuarioDao;
import com.example.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController{

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user1312 = new User();
        user1312.setId(id);
        user1312.setNombre("mozo");
        user1312.setApellido("Juajijajoija");
        user1312.setEmail("JJ@gmail.com");
        user1312.setTelefono("666131213");
        return user1312;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> getUsers(){
       List<User> usuarios = new ArrayList<>();
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public void newUser(@RequestBody User user){
        usuarioDao.newUser(user);
    }


    @RequestMapping(value = "/prueba1")
    public User updateUser(){
        User user13112 = new User();
        user13112.setNombre("mozo1");
        user13112.setApellido("Juajijajoija");
        user13112.setEmail("JJ@gmail.com");
        user13112.setTelefono("666131213");
        return user13112;
    }

    @RequestMapping(value = "/prueba2")
    public User createUser(){
        User user13122 = new User();
        user13122.setNombre("mozo2");
        user13122.setApellido("Juajijajoija");
        user13122.setEmail("JJ@gmail.com");
        user13122.setTelefono("666131213");
        return user13122;
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id ){
        usuarioDao.eliminar(id);
    }

}
