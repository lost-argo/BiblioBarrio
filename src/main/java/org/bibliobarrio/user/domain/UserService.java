package org.bibliobarrio.user.domain;

import org.bibliobarrio.user.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return  userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id" + id + " not found"));
    }

    public void addUser(User newUser){
        newUser.setRole("ROLE_READER");
        userRepository.save(newUser);
    }
}