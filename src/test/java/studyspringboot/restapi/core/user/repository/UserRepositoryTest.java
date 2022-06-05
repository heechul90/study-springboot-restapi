package studyspringboot.restapi.core.user.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import studyspringboot.restapi.core.user.domain.User;
import studyspringboot.restapi.core.user.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    private User getUser(String account, String email, String phoneNumber) {
        return User.builder()
                .account(account)
                .email(email)
                .phoneNumber(phoneNumber)
                .createdAt(LocalDateTime.now())
                .createdBy(account)
                .build();
    }

    @Test
    public void saveTest() throws Exception{
        //given
        User user1 = getUser("spring", "spring@spring.com", "010-0000-0000");

        //when
        User savedUser = userRepository.save(user1);

        //then
        User findUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertThat(findUser.getAccount()).isEqualTo("spring");
    }

    @Test
    public void findAllTest() throws Exception{
        //given
        User user1 = getUser("spring1", "spring@spring.com", "010-0000-0000");
        User user2 = getUser("spring2", "spring@spring.com", "010-0000-0000");
        userRepository.save(user1);
        userRepository.save(user2);
        em.flush();
        em.clear();

        //when
        List<User> users = userRepository.findAll();

        //then
        assertThat(users).extracting("account").containsExactly("spring1", "spring2");
    }

    @Test
    public void updateTest() throws Exception{
        //given
        User user = getUser("spring1", "spring@spring.com", "010-0000-0000");
        User savedUser = userRepository.save(user);
        em.flush();
        em.clear();

        //when
        User findUser = userRepository.findById(savedUser.getId()).orElse(null);
        findUser.changeEmail("java@java.com");
        em.flush();
        em.clear();

        //then
        User updatedUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertThat(updatedUser.getEmail()).isEqualTo("java@java.com");
    }

    @Test
    public void deleteTest() throws Exception{
        //given
        User user = getUser("spring1", "spring@spring.com", "010-0000-0000");
        User savedUser = userRepository.save(user);
        em.flush();
        em.clear();

        //when
        User findUser = userRepository.findById(user.getId()).orElse(null);
        userRepository.delete(findUser);
        em.flush();
        em.clear();

        //then
        User deletedUser = userRepository.findById(user.getId()).orElse(null);
        assertThat(deletedUser).isNull();
    }

}