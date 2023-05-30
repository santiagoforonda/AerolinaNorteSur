package com.proyectowed.proyectowed.Controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyectowed.proyectowed.Dtos.UserDtos.UserCreatedDto;
import com.proyectowed.proyectowed.Dtos.UserDtos.UserDto;
import com.proyectowed.proyectowed.Dtos.UserDtos.UserMapper;
import com.proyectowed.proyectowed.Entities.User;
import com.proyectowed.proyectowed.Service.UserService;

@RestController
@RequestMapping("/api/Users/")
public class UserController {


    private UserService usuarioServicio;
    private UserMapper mapeador;


    @Autowired
    public UserController(UserMapper mapeador, UserService usuarioServicio){
        this.usuarioServicio=usuarioServicio;
        this.mapeador=mapeador;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserCreatedDto> finById(@PathVariable Long id){
        UserCreatedDto usuarioCreado = usuarioServicio.finById(id).map(u -> mapeador.toUserCreatedDto(u)).orElseThrow();
        return ResponseEntity.status(HttpStatus.FOUND).body(usuarioCreado);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserCreatedDto>> finAll(){
        List<User> usuarios= usuarioServicio.findAll();
        List<UserCreatedDto> truUsuarios = usuarios.stream().map( u-> mapeador.toUserCreatedDto(u)).collect(Collectors.toList());
        return ResponseEntity.ok().body(truUsuarios);
    }

    @PostMapping("/users")
    public ResponseEntity<UserCreatedDto> create (@RequestBody UserDto usuario){
        User newUser = mapeador.toEntiy(usuario);
        User userCreated = null;
        userCreated = usuarioServicio.create(newUser);
        UserCreatedDto creadorEstudiante = mapeador.toUserCreatedDto(userCreated);
        URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(creadorEstudiante.getId()).toUri();
        return ResponseEntity.created(locacion).body(creadorEstudiante);
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<UserCreatedDto> upDate ( @PathVariable Long id, @RequestBody UserCreatedDto usuario){
            User userUpdate = mapeador.toUserEntity(usuario);
            return usuarioServicio.update(id, userUpdate).map( userActualizado -> ResponseEntity.ok().body(mapeador.toUserCreatedDto(userUpdate))).orElseGet(()->{
                User userCreado = usuarioServicio.create(userUpdate);
                UserCreatedDto userDtoCreado = mapeador.toUserCreatedDto(userUpdate);
                URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDtoCreado.getId()).toUri();
                return ResponseEntity.created(locacion).body(userDtoCreado);
            });
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
            return usuarioServicio.Delete(id);
    }

}
