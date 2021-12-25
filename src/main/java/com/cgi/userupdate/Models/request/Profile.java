
package com.cgi.userupdate.Models.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
@JsonDeserialize
public class Profile{

    public String id;

    public String firstName;

    public String lastName;

    public String email;

    public String groupId;
}