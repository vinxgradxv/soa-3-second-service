package com.example.second.clients;

import com.example.second.configuration.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "mainServiceClient", url = "https://localhost:8080", configuration = FeignConfig.class)
public interface MainServiceClient {

    @GetMapping(value = "{uri}", headers = "Content-Type=application/xml")
    String get(@RequestHeader HttpHeaders headers, @PathVariable("uri") String uri);

    @PostMapping(value = "{uri}", headers = "Content-Type=application/xml")
    String post(@RequestHeader HttpHeaders headers, @PathVariable("uri") String uri, @RequestBody String json);
}

