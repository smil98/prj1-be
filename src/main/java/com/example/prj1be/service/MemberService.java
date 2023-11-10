package com.example.prj1be.service;

import com.example.prj1be.domain.Member;
import com.example.prj1be.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mapper;

    public boolean add(Member member) {
        return mapper.insert(member)==1;
    }
}
