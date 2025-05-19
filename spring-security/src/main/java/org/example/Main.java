package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

}

@RestController
class MyController{

    private MyService myService;

//    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/public")
    public String hello1(){
        return "Hello this is a public API!";
    }

    @GetMapping("/user")
    public String hello2(){
        //Craquage total
        return myService.dangerousMethod();
//        return "Hello this is a USER API!";
    }

    @GetMapping("/admin")
    public String hello3(Principal principal){
        System.out.println(principal.getName());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return myService.dangerousMethod();
//        return "Hello this is a admin API!";
    }

}

@Service
class MyService{

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String dangerousMethod(){
        return "Hello this is a admin API!";
    }
}