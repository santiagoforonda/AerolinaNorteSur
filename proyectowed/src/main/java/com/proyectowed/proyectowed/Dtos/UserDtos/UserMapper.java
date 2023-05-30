package com.proyectowed.proyectowed.Dtos.UserDtos;

import org.springframework.stereotype.Component;

import com.proyectowed.proyectowed.Entities.User;

@Component
public class UserMapper {

    public UserMapper(){

    }

    public UserDto toDto(User usuario){
        UserDto usuarioDto= new UserDto();
        usuarioDto.setFullName(usuario.getFullName());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setPassword(usuario.getPassword());
        return usuarioDto;
    }

    public User toEntiy(UserDto usuarioDto){
        User user= new User();
        user.setFullName(usuarioDto.getFullName());
        user.setEmail(usuarioDto.getEmail());
        user.setPassword(usuarioDto.getPassword());
        return user;
    }


    public UserCreatedDto toUserCreatedDto(User usuario){
        UserCreatedDto usuarioCreadoDto=  new UserCreatedDto();

        usuarioCreadoDto.setId(usuario.getId());
        usuarioCreadoDto.setFullName(usuario.getFullName());
        usuarioCreadoDto.setEmail(usuario.getEmail());
        usuarioCreadoDto.setPassword(usuario.getPassword());

        return usuarioCreadoDto;
    }
    public User toUserEntity(UserCreatedDto usuarioCreado){
        User usuario= new User();

        usuario.setFullName(usuarioCreado.getFullName());
        usuario.setEmail(usuarioCreado.getEmail());
        usuario.setPassword(usuarioCreado.getPassword());

        return usuario;

    }

}
