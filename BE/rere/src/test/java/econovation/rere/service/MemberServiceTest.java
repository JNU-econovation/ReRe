package econovation.rere.service;

import econovation.rere.domain.member.Member;
import econovation.rere.domain.member.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setUserId("a");
        member.setPassword("1234");
        member.setNickname("test");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getNickname()).isEqualTo(findMember.getNickname());
    }

    @Test
    public void 중복아이디_예외() {
        //given
        Member member1 = new Member();
        member1.setUserId("a");
        member1.setPassword("1234");
        member1.setNickname("test1");

        Member member2 = new Member();
        member2.setUserId("a");
        member2.setPassword("1234");
        member2.setNickname("test2");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디입니다.");

        //then
    }

    @Test
    public void 중복닉네임_예외() {
        //given
        Member member1 = new Member();
        member1.setUserId("a1");
        member1.setPassword("1234");
        member1.setNickname("test");

        Member member2 = new Member();
        member2.setUserId("a2");
        member2.setPassword("1234");
        member2.setNickname("test");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 닉네임입니다.");

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}