package com.example;

import com.example.entity.Member;
import com.example.entity.Team;
import com.example.repo.MemberRepository;
import com.example.repo.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;

    @Test
    void testSelect() {
        Team team1 = new Team();
        team1.setName("강호동 팀");
        Team savedTeam1 = teamRepository.save(team1);

        Team team2 = new Team();
        team2.setName("이수근 팀");
        Team savedTeam2 = teamRepository.save(team2);

        Member member1 = new Member();
        member1.setName("은지원");
        member1.setTeam(savedTeam1);
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("김종민");
        member2.setTeam(savedTeam2);
        memberRepository.save(member2);

        Member member3 = new Member();
        member3.setName("이승기");
        member3.setTeam(savedTeam2);
        memberRepository.save(member3);

        Member member4 = new Member();
        member4.setName("MC몽");
        member4.setTeam(savedTeam2);
        memberRepository.save(member4);

        memberRepository.findAll().forEach(System.out::println);
    }
}
