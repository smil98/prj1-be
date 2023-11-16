package com.example.prj1be.service;

import com.example.prj1be.domain.Auth;
import com.example.prj1be.domain.Member;
import com.example.prj1be.mapper.BoardMapper;
import com.example.prj1be.mapper.CommentMapper;
import com.example.prj1be.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mapper;
    private final BoardMapper boardMapper;
    private final CommentMapper commentMapper;

    public boolean add(Member member) {
        return mapper.insert(member)==1;
    }

    public String getId(String id) {
        return mapper.selectId(id);
    }

    public String getEmail(String email) {
        return mapper.selectEmail(email);
    }

    public boolean validate(Member member) {
        if (member == null) {
            return false;
        }

        if (member.getEmail().isBlank()) {
            return false;
        }

        if (member.getPassword().isBlank()) {
            return false;
        }

        if (member.getId().isBlank()) {
            return false;
        }
        return true;
    }

    public List<Member> list() {
        return mapper.selectAllMembers();
    }

    public Member getMember(String id) {
        return mapper.selectById(id);
    }

    public boolean deleteMember(String id) {
        //delete posts that this member wrote
        boardMapper.deleteByWriter(id);
        commentMapper.deleteByMemberId(id);
        return mapper.deleteById(id)==1;
    }

    public boolean update(Member member) {
        //Member oldMember = mapper.selectById(member.getId());
        //if(member.getPassword().equals("")) {
        //    member.setPassword(oldMember.getPassword());
        //}
        return mapper.updateById(member)==1;
    }

    public String getNickName(String nickName) {
        return mapper.selectNickName(nickName);
    }

    public boolean login(Member member, WebRequest request) {
        Member dbMember = mapper.selectById(member.getId());

        if(dbMember != null && dbMember.getPassword().equals(member.getPassword())) {
            List<Auth> auth = mapper.selectAuthById(member.getId());
            dbMember.setAuth(auth);
            dbMember.setPassword("");
            request.setAttribute("login", dbMember, RequestAttributes.SCOPE_SESSION);
            return true;
        }
        return false;
    }

    public boolean hasAccess(String id, Member login) {
        if(isAdmin(login)) {
            return true;
        }

        return login.getId().equals(id);
    }

    public boolean isAdmin(Member login) {
        if(login.getAuth() != null) {
            return login.getAuth()
                    .stream()
                    .map(e-> e.getName())
                    .anyMatch(n -> n.equals("admin"));
        }

        return false;
    }
}
