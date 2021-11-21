package hello.core2;

import hello.core2.member.Grade;
import hello.core2.member.Member;
import hello.core2.member.MemberRepository;
import hello.core2.member.MemoryMemberRepository;

public class MemberApp {

    public static void main(String[] args) {

        MemberRepository memberRepository = new MemoryMemberRepository();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberRepository.save(member);

        Member member1 = memberRepository.findById(member.getId());
        System.out.println("member1 = " + member1.getId());
    }


}
