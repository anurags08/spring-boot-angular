package com.assignment.reg.service.api.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.assignment.reg.service.api.dao.UserRepository;
import com.assignment.reg.service.api.model.User;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
    	try {
        repository.save(user);
        return "Hi " + user.getName() + " your Registration process successfully completed";
    	}catch(Exception e) {
    		return "some Exception occur "+e;
    	}
    	
    }
    
    @GetMapping("/getAllUsers")
    public List<User> findAllUsers() {
         try {
        return repository.findAll();
         }catch(Exception e) {
        	 List<User> l= new LinkedList<>();
        	 return l;
         }
    }

    @GetMapping("/findUser/{email}")
    public List<User> findUser(@PathVariable String email) {
        List<User> users=new LinkedList<>();
        users=repository.findByEmail(email);
        if(users==null)
        	return null;
        else
        	return users;
        
    }

    @DeleteMapping("/cancel/{id}")
    public List<User> cancelRegistration(@PathVariable int id) {
    	try {
        repository.deleteById(id);
        return repository.findAll();
    	}catch(Exception e) {
    		
    		System.out.println("id or user does't Exist");
    		List<User> l= new ArrayList<>();
    		return l;
    	}
        
    }
    
    @PostMapping("/update/{email}")
	public User updateStudent(@PathVariable String email,User user) {
    	User newUser= (User) repository.findByEmail(email);
    	 newUser.setName(user.getName());
    	 newUser.setDomain(user.getDomain());
    	 newUser.setExperience(user.getExperience());
		return repository.save(user);
	}

}
