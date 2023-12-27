package econovation.rere.repository;

import econovation.rere.domain.member.Member;
import econovation.rere.domain.member.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setUserId("aaa");
        member.setPassword("1234");
        member.setNickname("test");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByUserId() {
        //given
        Member member1 = new Member();
        member1.setUserId("test1");
        member1.setPassword("1234");
        member1.setNickname("omh1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setUserId("test2");
        member2.setPassword("1234");
        member2.setNickname("omh2");
        repository.save(member2);

        //when
        Member result = repository.findByUserId("test1").get();

        //then
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findByNickname() {
        //given
        Member member1 = new Member();
        member1.setUserId("test1");
        member1.setPassword("1234");
        member1.setNickname("omh1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setUserId("test2");
        member2.setPassword("1234");
        member2.setNickname("omh2");
        repository.save(member2);

        //when
        Member result = repository.findByNickname("omh1").get();

        //then
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setUserId("test1");
        member1.setPassword("1234");
        member1.setNickname("omh1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setUserId("test2");
        member2.setPassword("1234");
        member2.setNickname("omh2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
