package com.example.prj1be.controller;

import com.example.prj1be.domain.Member;
import com.example.prj1be.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService service;

    @PostMapping("join")
    public void signup(@RequestBody Member member) {
        System.out.println("member = " + member);
        service.add(member);
    }

    @GetMapping(value="check", params = "id")
    public ResponseEntity checkId(String id) {
        if(service.getId(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
}
