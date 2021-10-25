package com.myemployees.myemployees.controller;



import com.myemployees.myemployees.model.user;
import com.myemployees.myemployees.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class apicontroller {
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/users")
    public List<user> getusers(){
        return userRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody user user){

        userRepo.save(user);
        return "saved...";
    }
    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody user user){
        user updatedUser=userRepo.findById(id).get();
        updatedUser.setFname((user.getFname()));
        updatedUser.setLname((user.getLname()));
        updatedUser.setEmpno((user.getEmpno()));
        userRepo.save(updatedUser);
        return "updated...";

    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteuser(@PathVariable long id){
        user deleteuser=userRepo.findById(id).get();
        userRepo.delete(deleteuser);
        return "deleted user with the id :" +id;

    }

}
