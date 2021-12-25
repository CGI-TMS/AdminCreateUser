package com.cgi.userupdate.Models.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@JsonDeserialize
@Data

public class UpdateUserRequest {

    public String password;
    public String authenticatedUserPassword;
}

