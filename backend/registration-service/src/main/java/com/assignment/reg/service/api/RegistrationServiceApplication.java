package com.assignment.reg.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.assignment.reg.service.api.dao.UserRepository;
import com.assignment.reg.service.api.model.User;

import java.util.List;

@SpringBootApplication
public class RegistrationServiceApplication {

    
    public static void main(String[] args) {
        SpringApplication.run(RegistrationServiceApplication.class, args);
    }

}


