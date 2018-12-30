package com.nokchax.observer.controller;

import com.nokchax.observer.service.GitService;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Setter
@Controller
public class IncomingController {
    private GitService gitService;

    @PostMapping("/bot")
    public void incoming(@RequestBody String body) {
        System.out.println(body);
    }
}
