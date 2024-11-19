package com.example.second.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@JacksonXmlRootElement(localName = "studio")
public class Studio {
    private Integer id;
    @NonNull
    private String name; // cannot be null
}