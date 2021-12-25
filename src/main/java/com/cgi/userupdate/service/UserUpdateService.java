package com.cgi.userupdate.service;

import com.cgi.userupdate.Models.request.AddUserRequest;
import com.cgi.userupdate.Models.request.Groups;
import com.cgi.userupdate.Models.request.UpdateUserRequest;
import com.cgi.userupdate.exception.UserUpdateException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface UserUpdateService {
    public String addUser(AddUserRequest addUserRequest) throws UserUpdateException;

    public String updateUser(UpdateUserRequest updateUserRequest, String id) throws UserUpdateException;

    public List<Groups> retrieveGroups() throws UserUpdateException;
}

