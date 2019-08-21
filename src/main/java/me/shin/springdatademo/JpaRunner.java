package me.shin.springdatademo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Account account = new Account();
        account.setUsername("ilhyun");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);    // 아래 두 코드를 매서드를 만들어서 처리

//        account.getStudies().add(study);    // 옵셔널이지만 객체지향적으로 생각했을 때
//        study.setOwner(account);// 양방향이기 때문에 추가

        entityManager.persist(account);
        entityManager.persist(study);
    }
}
