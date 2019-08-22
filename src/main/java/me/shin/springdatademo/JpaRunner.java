package me.shin.springdatademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        postRepository.findAll().forEach(System.out::println);
    }
}
