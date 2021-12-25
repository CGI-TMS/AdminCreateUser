package com.cgi.userupdate.Models.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@JsonDeserialize
@Data
public class AddUserRequest {
    public Profile profile;
    public Credentials credentials;
}

