package com.cgi.userupdate.service;

import com.cgi.userupdate.Models.request.AddUserRequest;
import com.cgi.userupdate.Models.request.Groups;
import com.cgi.userupdate.Models.request.UpdateUserRequest;
import com.cgi.userupdate.client.IcamnudaClient;
import com.cgi.userupdate.exception.UserUpdateException;
import com.cgi.userupdate.utils.MailUtility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
@Slf4j
public class UserUpdateServiceImpl implements UserUpdateService {

    private IcamnudaClient client;
    private MailUtility utility;


    @Override
    public String addUser(AddUserRequest request) throws UserUpdateException {

        try {
            String response = client.addUser(request);

            String addUserToGroup = client.addMemberToGroup(request.getProfile().getGroupId(), request.getProfile().getId());
            utility.sendEmail(request);

        } catch (Exception e) {
            log.error("Exception Occured while Adding user to group", e);
            throw new UserUpdateException(e.getMessage());
        }
        return "";


    }

    @Override
    public String updateUser(UpdateUserRequest request, String id) throws UserUpdateException {

        try {
            String response = client.updateUser(id, request);
        } catch (Exception e) {
            log.error("Exception Occured while Updating User Credential", e);
            throw new UserUpdateException(e.getMessage());
        }
        return "";
    }

    @Override
    public List<Groups> retrieveGroups() throws UserUpdateException {


       try {
           return client.retrieveGroups();
       }catch (Exception e) {
           log.error("Exception Occured while retrieving groups", e);
           throw new UserUpdateException(e.getMessage());
       }
    }


}
