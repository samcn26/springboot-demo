package com.sam_tech.test_springboot.controller;

import com.sam_tech.test_springboot.exceptions.UserServiceException;
import com.sam_tech.test_springboot.model.request.UserDetailsRequestModel;
import com.sam_tech.test_springboot.model.response.UserRest;
import com.sam_tech.test_springboot.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    Map<String, UserRest> users;

    // @edu work with service and which with @service annotation
    @Autowired
    UserService userService;

    // @edu @RequestParam params in query
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return String.format("the page is %d, and limit %d, and sort %s", page, limit, sort);
    }

    // @edu @PathVariable params in path
    // @edu response type  xml: add dependency jackson-dataformat-xml
    // curl -X GET -H "Accept: application/json" http://localhost:8080/users/1234
    // curl -X GET -H "Accept: application/xml" http://localhost:8080/users/1234
    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    // @edu use ResponseEntity combine status code.
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        UserRest rt = new UserRest("sam", "tech", "samtech@test.com", userId);
        return new ResponseEntity<>(rt, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    // @edu @Valid validation spring-boot-starter-validation
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest rt = userService.createUser(userDetails);


        return new ResponseEntity<>(rt, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "put";
    }

    @DeleteMapping
    public ResponseEntity deleteUser() {
    // logic

    // @edu return no content
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public String testexception() {
        if (true) {
            throw new UserServiceException("User service exception is thrown");
        }

        // String s = null;
        // int i = s.length();
        return "test";
    }
}
