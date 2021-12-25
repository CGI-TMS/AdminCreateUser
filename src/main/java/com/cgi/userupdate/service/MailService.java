package com.cgi.userupdate.service;

import com.cgi.userupdate.Models.request.Mail;
import org.springframework.stereotype.Service;

@Service
public interface MailService {
    public void sendEmail(Mail mail);
}
