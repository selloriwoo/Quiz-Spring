package com.PJR.Quiz.service.impl;

import com.PJR.Quiz.entity.User;
import com.PJR.Quiz.repository.UserRepository;
import com.PJR.Quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User signUp(User user) {
        Optional<User> user1=userRepository.findByUserName(user.getUserName());
        if(user1.isPresent()){
            return null;
        } else {
            User u = userRepository.save(user);
            return u;
        }
    }

    @Override
    public String loginCheck(User user) {
        Optional<User> user1= userRepository.findByUserName(user.getUserName());
        if(user1 != null){
            User u = user1.get();

            if(user.getUserPwd().equals(u.getUserPwd())){
                return "YES";
            }
        }
        return "NO";
    }
}
