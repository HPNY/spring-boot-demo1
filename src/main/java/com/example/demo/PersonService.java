package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional//事务注解
    public void insertTwo(){
        Person person1=new Person();
        person1.setName("C");
        person1.setAge(19);
        personRepository.save(person1);

        Person person2=new Person();
        person2.setName("D");
        person2.setAge(21);
        personRepository.save(person2);
    }
}
