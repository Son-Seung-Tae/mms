package com.example.MMS.repository;

import com.example.MMS.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 메서드 종료시 마다 호출되는 메서드
    @AfterEach
    public  void  afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("son");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public  void  findByName() {
        Member member = new Member();
        member.setName("son");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("sonny");
        repository.save(member2);


        Member membertest = repository.findByName("son").get();

        Assertions.assertEquals(membertest, member);
    }

    @Test
    public void findAll() {
        List<Member> lm = new ArrayList<>();

        Member member = new Member();
        member.setName("son");
        repository.save(member);
        lm.add(member);

        Member member2 = new Member();
        member2.setName("sonny");
        repository.save(member2);
        lm.add(member2);

        List<Member> result = repository.findAll();

        Assertions.assertEquals(lm, result);
    }




}
