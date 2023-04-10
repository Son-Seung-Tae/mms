package com.example.MMS.service;

import com.example.MMS.domain.Member;
import com.example.MMS.repository.MemberRepository;
import com.example.MMS.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    /*
    @Component 애노테이션이 있으면 스프링 빈으로 자동 등록 됨.
    - @Controller
    - @Service
    - @Repository
     */

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> {throw  new IllegalStateException("이미 존재하는 회웝입니다.");});
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
