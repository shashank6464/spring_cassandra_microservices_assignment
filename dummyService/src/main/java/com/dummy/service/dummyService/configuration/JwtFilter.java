package com.dummy.service.dummyService.configuration;

import com.dummy.service.dummyService.controller.AuthenticationConsumer;
import com.dummy.service.dummyService.controller.ConsumerController;
import com.dummy.service.dummyService.model.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class JwtFilter extends GenericFilterBean {

    private AuthenticationConsumer tokenConsumerService;

    private ConsumerController controller;

    public JwtFilter(AuthenticationConsumer tokenConsumerService,
                     ConsumerController controller){
        this.tokenConsumerService = tokenConsumerService;
        this.controller = controller;
    }


    //do filtering
    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;

        String token = httpServletRequest.getHeader("Authorization");
        if("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.sendError(HttpServletResponse.SC_OK, "success");
            return;
        }
        if(allowRequestWithoutToken(httpServletRequest)){
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(req,res);
        }
        else{
            String userId = controller.getUserIdFromToken(token);
            System.out.println(userId+"**************************************************");
            httpServletRequest.setAttribute("userId",userId);
            filterChain.doFilter(req,res);
        }
    }

    //for allowing without jwt token
    public boolean allowRequestWithoutToken(HttpServletRequest httpServletRequest){
        System.out.println(httpServletRequest.getRequestURI());
        if(!httpServletRequest.getRequestURI().contains("/employee"))
            return true;

        return false;
    }


}