package br.com.baci.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    
    @GetMapping
    public ResponseEntity getMensagem(){
        return ResponseEntity.ok().body("Spring boot is working!!");
    }

}