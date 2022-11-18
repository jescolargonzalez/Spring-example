package com.example.spring.controller;

import com.example.spring.dao.UsuarioDao;
import com.example.spring.model.User;
import com.example.spring.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController{

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;

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
    public List<User> getUsers(@RequestHeader(value="Authorization") String token){
        if(!validarToken(token)){ return null; }
        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public void newUser(@RequestBody User user){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,user.getPassword());
        user.setPassword(hash);
        usuarioDao.newUser(user);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token ,@PathVariable Long id ){
        if(!validarToken(token)){ return ; }
        usuarioDao.eliminar(id);
    }

}
