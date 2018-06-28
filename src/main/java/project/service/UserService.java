package project.service;

import project.model.User;

import java.util.Optional;

public interface UserService{
        void saveUser(User user);
        User findByUsername(String email);
        Optional<User> findById(Long id);

}
