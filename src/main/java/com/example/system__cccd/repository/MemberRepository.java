package com.example.system__cccd.repository;

import com.example.system__cccd.entity.member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<member, Integer> {
    member findByUsername(String username);
}
