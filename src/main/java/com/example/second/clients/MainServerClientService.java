package com.example.second.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;

@Service
public class MainServerClientService {

    @Autowired
    private MainServiceClient restClient;

    public String get(String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        return restClient.get(headers, uri);
    }

    public String post(String uri, String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        return restClient.post(headers, uri, json);
    }
}

