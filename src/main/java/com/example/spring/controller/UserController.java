package com.example.spring.controller;

import com.example.spring.dao.UsuarioDao;
import com.example.spring.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController{
    @RequestMapping(value = "/user/{id}")
    public User getUser(@PathVariable Long id){
        User user1312 = new User();
        user1312.setId(id);
        user1312.setNombre("mozo");
        user1312.setApellido("Juajijajoija");
        user1312.setEmail("JJ@gmail.com");
        user1312.setTelefono("666131213");
        return user1312;
    }

    @RequestMapping(value = "/users")
    public List<User> getUsers(){
       List<User> usuarios = new ArrayList<>();

        User user1312 = new User();
        user1312.setId(123L);
        user1312.setNombre("mozo");
        user1312.setApellido("Juajijajoija");
        user1312.setEmail("JJ@gmail.com");
        user1312.setTelefono("666131213");

        User user13112 = new User();
        user13112.setId(111L);
        user13112.setNombre("poo");
        user13112.setApellido("stoorm");
        user13112.setEmail("poostorm@gmail.com");
        user13112.setTelefono("666131213");

        User user13123 = new User();
        user13123.setId(223L);
        user13123.setNombre("pepe");
        user13123.setApellido("palotes");
        user13123.setEmail("AAAAGGHHH@gmail.com");
        user13123.setTelefono("123451234");

        usuarios.add(user1312);
        usuarios.add(user13112);
        usuarios.add(user13123);
        return usuarios;
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

    @RequestMapping(value = "/prueba3")
    public User deleteUser(){
        User user13123 = new User();
        user13123.setNombre("mozo3");
        user13123.setApellido("Juajijajoija");
        user13123.setEmail("JJ@gmail.com");
        user13123.setTelefono("666131213");
        return user13123;
    }

}
