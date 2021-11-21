package hello.core2.discount;

import hello.core2.member.Grade;
import hello.core2.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return 1000;
        } else {
            return 0;
        }
    }
}
