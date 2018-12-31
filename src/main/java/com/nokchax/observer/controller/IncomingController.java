package com.nokchax.observer.controller;

import com.nokchax.observer.service.GitService;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Setter
@RestController
public class IncomingController {
    private GitService gitService;

    @PostMapping("/bot")
    public Map<String, String> incoming(@RequestBody Map<String, String> body) {
        System.out.println(body);
        return body;
    }
}