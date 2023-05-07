package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/getEmployee/{schoolname}", method = RequestMethod.GET)
    public String getEmployee(@PathVariable String schoolname)
    {
        System.out.println("Getting Employee details for " + schoolname);

        String response = restTemplate.exchange("http://producer-service/getEmployee",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolname).getBody();

        System.out.println("Response Received as " + response);

        return "Employee Details " + response;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
