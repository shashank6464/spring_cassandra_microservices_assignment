package com.signup.service.signupService.proxyServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("authentication-service/auth")
public interface AuthenticationConsumer {

    @GetMapping("/get-token")
    String createToken(int id);


}