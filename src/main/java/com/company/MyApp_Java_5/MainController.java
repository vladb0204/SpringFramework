package com.company.MyApp_Java_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private UserRepository userR;

    @GetMapping(path="/printString")
    public String printString(String index) {
        return "index";
    }

    @GetMapping(path="/add")
    @ResponseBody String addNewUser(@RequestParam String name, @RequestPart String email) {
        UserData user = new UserData();
        user.setEmail(email);
        user.setName(name);
        userR.save(user);
        return "Saved!";
    }

    @GetMapping(path="/all")
    @ResponseBody Iterable<UserData>
    getAllUsers() {
        return userR.findAll();
    }
}
