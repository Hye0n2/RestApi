package com.example.post.controller;

// import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post.dto.PostRequestDto;

@RestController
@RequestMapping("/api")
public class PostApiController {
    
    // @PostMapping("/post")
    // public void post(@RequestBody Map<String, Object> requestData) {

    //     // requestData.forEach((key, value) -> {
    //     //     System.out.println("key : " + key);
    //     //     System.out.println("value : " + value);
    //     // });

    //     requestData.entrySet().forEach(stringObjectEntry -> {
    //         System.out.println("key : " + stringObjectEntry.getKey());
    //         System.out.println("value : " + stringObjectEntry.getValue());
    //     });
    // }

    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto requestData) {

        System.out.println(requestData);
    }
}