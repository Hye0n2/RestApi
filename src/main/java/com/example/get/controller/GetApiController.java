package com.example.get.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.get.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    
    @GetMapping(path = "/hello")    // http://localhost:8080/api/get/hello
    public String hello() {
        return "get Hello";
    }

    // 옛날 방식
    @RequestMapping(path = "/hi", method = RequestMethod.GET)      // get   http://localhost:8080/api/get/hi
    public String hi() {
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{id}
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName) {
        System.out.println("PathVariable : "  + pathName);
        return pathName;
    }

    // localhost:8080/api/get/query-param?name=HongGilDong&email=hong@test.com&age=8
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ) {
        
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }


    // ?name=HongGilDong&email=hong@test.com&age=8
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest) {
        
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
