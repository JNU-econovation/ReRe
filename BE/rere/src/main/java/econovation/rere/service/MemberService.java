package econovation.rere.service;

import econovation.rere.domain.member.Member;
import econovation.rere.domain.member.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {

        validateDuplicateUserId(member); // 아이디 중복 체크
        validateDuplicateNickname(member); // 닉네임 중복 체크
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateNickname(Member member) {
        memberRepository.findByNickname(member.getNickname())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
                        });
    }

    private void validateDuplicateUserId(Member member) {
        memberRepository.findByUserId(member.getUserId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
