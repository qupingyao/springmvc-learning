package com.yqp.web.service.impl;

import org.springframework.stereotype.Service;
import com.yqp.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public String say(String word) {
		return "hello" + word;
	}

}