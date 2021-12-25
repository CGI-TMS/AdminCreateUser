package com.cgi.userupdate.controller;


import com.cgi.userupdate.Models.request.AddUserRequest;
import com.cgi.userupdate.Models.request.Groups;
import com.cgi.userupdate.Models.request.UpdateUserRequest;
import com.cgi.userupdate.exception.UserUpdateException;
import com.cgi.userupdate.service.UserUpdateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("${spring.data.rest.base-path}")
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserUpdateController {
    private UserUpdateService service;

    @PostMapping("/user/create")
    public ResponseEntity addUser(
            @RequestBody AddUserRequest addUserRequest) throws UserUpdateException {
        return new ResponseEntity(service.addUser(addUserRequest), HttpStatus.NO_CONTENT);

    }

    @PutMapping(path = "/user/{id}/credentials")
    public ResponseEntity updateUserPassword(
            @PathVariable(required = true,name = "id") String id,
            @RequestBody UpdateUserRequest updateUserRequest) throws UserUpdateException {
        return  new ResponseEntity(service.updateUser(updateUserRequest,id),HttpStatus.NO_CONTENT);

    }
    @GetMapping(path = "/retrieve/users")
    public List<Groups> retrieveGroups() throws UserUpdateException {
        return service.retrieveGroups();

    }






}
