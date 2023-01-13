package com.example.repo;

import com.example.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByName(String name);

    @EntityGraph("MemberWithTeam")
    List<Member> findAll();
}
