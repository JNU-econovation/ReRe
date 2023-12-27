package econovation.rere.domain.member;

import econovation.rere.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByUserId(String userId);
    Optional<Member> findByNickname(String nickmame);
    List<Member> findAll();
}
