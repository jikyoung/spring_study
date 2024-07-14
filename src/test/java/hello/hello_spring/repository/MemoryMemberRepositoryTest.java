package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Optional;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
//given
        Member member = new Member();
        member.setName("spring");
//when
        repository.save(member);
//then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }
}
