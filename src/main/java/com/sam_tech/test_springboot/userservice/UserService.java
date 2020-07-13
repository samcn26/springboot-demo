package com.sam_tech.test_springboot.userservice;

import com.sam_tech.test_springboot.model.request.UserDetailsRequestModel;
import com.sam_tech.test_springboot.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
