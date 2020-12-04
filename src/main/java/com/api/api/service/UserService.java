package com.api.api.service;

import com.api.api.model.Task;
import com.api.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.api.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUsers(final String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(User user) {
        Optional<User> userExist = userRepository.findByEmail(user.getEmail());
        if(userExist.isEmpty()){
            User u = new User();
            u.setUsername(user.getUsername());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            userRepository.save(u);
            return u;
        }

        return null;
    }

    public User registerUser(User user) {
        Optional<User> userIsExist = userRepository.findByEmail(user.getEmail());
        if(userIsExist.isPresent()){
            var userExist = userIsExist.get();
            if(userExist.getPassword().equals(user.getPassword())){
                return userExist;
            }
        }
        return null;
    }
}
