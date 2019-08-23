package me.shin.springdatademo;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;

@NoRepositoryBean
public interface MyRepository<T, ID> extends Repository<T, ID> {

    <E extends T>E save(E entity);

    List<T> findAll();
}
