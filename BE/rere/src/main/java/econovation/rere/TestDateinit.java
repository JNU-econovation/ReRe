package econovation.rere;

import econovation.rere.domain.member.Member;
import econovation.rere.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDateinit {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setUserId("test");
        member.setPassword("1234");
        member.setNickname("테스터");
        memberRepository.save(member);
    }
}
