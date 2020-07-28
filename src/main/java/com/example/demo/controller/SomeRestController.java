package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class SomeRestController {

    private WebClient webClient;

    public SomeRestController(@Qualifier("clientCredentialsWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/test")
    public Object root() {
        return webClient.get()
                 .uri("http://localhost:8080/api/heroes/1")
                 .exchange()
                 .block();
    }
}
