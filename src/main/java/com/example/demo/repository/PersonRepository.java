package com.example.demo.repository;

import com.example.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    //通过年龄来查询
    public List<Person> findByAge(Integer age);
}
