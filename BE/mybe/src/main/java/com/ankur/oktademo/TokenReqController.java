package com.ankur.oktademo;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenReqController {
    @GetMapping("/locked")
    @CrossOrigin
    public ResponseEntity<String> gettkn() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.status(HttpStatus.OK).body("nice");
    }

    @GetMapping("/open")
    @CrossOrigin
    public ResponseEntity<String> getNotkn() {
        ResponseEntity<String> resp = new ResponseEntity<>("No TKN", HttpStatusCode.valueOf(200));
        return resp;
    }
}
