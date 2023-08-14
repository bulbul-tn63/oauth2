package com.example.clientserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping("/demo")
  public String demo() {
    return "Demo";
  }

  @GetMapping("/user/auth")
  public String user(){
    return "User";
  }
}
