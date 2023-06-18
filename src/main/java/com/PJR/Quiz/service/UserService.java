package com.PJR.Quiz.service;

import com.PJR.Quiz.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User signUp(User user);

    String loginCheck(User user);
}
