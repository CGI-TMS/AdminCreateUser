package com.cgi.userupdate.Models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Groups {


    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
}
