package com.example.system__cccd.service.impl;

import com.example.system__cccd.entity.member;
import com.example.system__cccd.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.system__cccd.service.memberService;

import java.util.ArrayList;

@Service
public class memberServiceImpl implements memberService{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void save(member mem) {
        mem.setPassword(passwordEncoder.encode(mem.getPassword()));
        memberRepository.save(mem);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        member mem = memberRepository.findByUsername(username);
        if (mem == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                mem.getUsername(),
                mem.getPassword(),
                new ArrayList<>()
        );
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

