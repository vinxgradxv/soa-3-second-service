package com.example.second.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Generated;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@JacksonXmlRootElement(localName = "MusicBand")
public class MusicBand {

    @Generated
    private Integer id; // autogenerated
    @NonNull
    private String name; // cannot be null, non-empty
    @NonNull
    private Coordinates coordinates; // cannot be null
    private int numberOfParticipants; // must be > 0
    private int singlesCount; // must be > 0
    private long albumsCount; // must be > 0
    private MusicGenre genre; // can be null
    @NonNull
    private Studio studio; // cannot be null
}
