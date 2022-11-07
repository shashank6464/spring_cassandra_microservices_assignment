package com.authentication.service.authenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }


    //get token by id
    @GetMapping("/get-token/{id}")
    public String createToken(@PathVariable("id") int userId){
        return tokenService.createToken(userId);
    }

    //get user id from token
    @GetMapping("/get-userId-from-token/{token}")
    public String getUserIdFromToken(@PathVariable("token") String token){
        return tokenService.getUserIdFromToken(token);
    }
}