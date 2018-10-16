package com.yqp.web.service.impl;

import com.yqp.web.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String say(String word) {
        return "hello" + word;
    }

}