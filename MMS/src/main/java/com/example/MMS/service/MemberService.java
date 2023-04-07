package com.example.MMS.service;

import com.example.MMS.domain.Member;
import com.example.MMS.repository.MemberRepository;
import com.example.MMS.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {

//        Duplicate
        memberRepository.save(member);

        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
