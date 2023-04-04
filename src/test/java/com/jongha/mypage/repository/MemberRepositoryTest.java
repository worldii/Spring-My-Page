package com.jongha.mypage.repository;

import com.jongha.mypage.domain.Member;
import com.jongha.mypage.dto.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository userRepository;
    @Autowired
    EntityManager em;

    private void clear () {
        em.flush();;
        em.clear();
    }
    @AfterEach
    private  void after() {
        em.clear();
    }


    @Test
    public void 회원가입_성공() {

        // given
        Member user = Member.builder().userName("jongha").password("1234").name("박종하").role(Role.USER).build();

        // when
        Member saveUser = userRepository.save(user);

        // then
        Member findMember = userRepository.findById(saveUser.getId()).orElseThrow(()-> new RuntimeException("저장된 회원이 없다. "));
        assertThat(findMember).isSameAs(saveUser);
    }


}