package com.example.second.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@JacksonXmlRootElement(localName = "coordinates")
public class Coordinates {
    private Integer id;
    @NonNull
    private Double x; // cannot be null
    @NonNull
    private Float y; // cannot be null
}
