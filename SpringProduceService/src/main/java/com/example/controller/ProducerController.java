package com.example.controller;

import com.example.model.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProducerController {

    private List<Employee> result = new ArrayList<Employee>();
    
    public ProducerController(){
        Employee emp = new Employee();
        emp.setName("emp1");
        emp.setDesignation("manager");
        emp.setEmpId("1");
        emp.setSalary(3000);
        result.add(emp);
    }

    @RequestMapping(value = "/getEmployee", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> getEmployee(){
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
