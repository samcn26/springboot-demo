package com.sam_tech.test_springboot.userservice.impl;

import com.sam_tech.test_springboot.model.request.UserDetailsRequestModel;
import com.sam_tech.test_springboot.model.response.UserRest;
import com.sam_tech.test_springboot.shared.Utils;
import com.sam_tech.test_springboot.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;

    Utils utils;

//    @edu inject other service
    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    public UserServiceImpl() {
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        String userId = utils.generateUserId();
        UserRest rt = new UserRest(userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail(), userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, rt);
        return rt;
    }
}
