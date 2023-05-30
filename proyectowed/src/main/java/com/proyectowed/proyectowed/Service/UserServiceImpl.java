package com.proyectowed.proyectowed.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyectowed.proyectowed.Entities.User;
import com.proyectowed.proyectowed.Repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo=userRepo;
    }

    @Override
    public User getById(Long id) {
        return userRepo.getReferenceById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> finById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User create(User user) {
        User copy= new User(null,user.getFullName(),user.getEmail(), user.getPassword());
        return userRepo.save(copy);
    }

    @Override
    public Optional<User> update(Long id, User oldUser) {
        return userRepo.findById(id).map(usuario->{
            User sus= usuario.UpdarteWidth(oldUser);
            return userRepo.save(sus);
        });
    }

    @Override
    public ResponseEntity<?> Delete(Long id) {
        userRepo.deleteById(id);
        return (ResponseEntity) ResponseEntity.ok();
    }

}
