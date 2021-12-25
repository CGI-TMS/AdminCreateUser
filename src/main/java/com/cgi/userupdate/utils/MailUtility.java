package com.cgi.userupdate.utils;

import com.cgi.userupdate.Models.request.AddUserRequest;
import com.cgi.userupdate.Models.request.Mail;
import com.cgi.userupdate.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MailUtility {


    private MailService mailService;


    public void sendEmail(AddUserRequest request) {
        Mail mail = new Mail();
        mail.setMailFrom("noreply@cgi.com");

        mail.setMailTo(request.getProfile().getEmail());
        mail.setMailSubject(" User Created Successfully");
        mail.setMailContent("Hi " + request.getProfile().getFirstName() + "\nCongratulations. You have been successfully added to group with groupId: " + request.getProfile().getGroupId() + ". Your credentials are: \n\nUserId: " +
                request.getProfile().getEmail() +"\nInitial Password: "+request.getCredentials().getPassword()+ "\n\nPlease change your password using the url: www.cgi.comn. \n\nThanks\nwww.cgi.com");

        mailService.sendEmail(mail);

    }
}
