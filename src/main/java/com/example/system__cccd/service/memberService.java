package com.example.system__cccd.service;


import com.example.system__cccd.entity.member;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface memberService {
    void save(member mem);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    boolean checkPassword(String rawPassword, String encodedPassword);
}

