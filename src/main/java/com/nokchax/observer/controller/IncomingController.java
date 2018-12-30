package com.nokchax.observer.controller;

import com.nokchax.observer.service.GitService;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Setter
@RestController
public class IncomingController {
    private GitService gitService;

    @PostMapping("/bot")
    public void incoming(@RequestBody String body) {
        System.out.println(body);
    }
}
