package com.example.prj1be.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

public class AppErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError() {
        return "/";
    }
}
