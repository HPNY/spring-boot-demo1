package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    /**
     * 查询所有person列表
     * @return
     */
    @GetMapping(value = "/persons")
    public List<Person> personList(){
        return personRepository.findAll();
    }

    /**
     * 添加一个person
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/persons")
    public Person personAdd(@RequestParam("name") String name,@RequestParam("age") Integer age){
        Person person=new Person();
        person.setAge(age);
        person.setName(name);
        return personRepository.save(person);
    }

    /**
     * 根据ID查询person
     * @param id
     * @return
     */
    @GetMapping(value = "/persons/{id}")
    public Person personFindOne(@PathVariable("id") Integer id){
        return personRepository.findById(id).orElse(null);
    }

    /**
     * 根据ID更新person
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping(value = "/persons/{id}")
    public Person personUpdate(@PathVariable("id") Integer id,@RequestParam("name") String name,@RequestParam("age") Integer age){
        Person person=new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        return personRepository.save(person);
    }

    /**
     * 根据ID删除person
     * @param id
     */
    @DeleteMapping(value = "/persons/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        personRepository.deleteById(id);
    }

    /**
     * 根据年龄查询person列表
     * @param age
     * @return
     */
    @GetMapping(value = "/persons/age/{age}")
    public List<Person> personListByAge(@PathVariable("age") Integer age){
        return personRepository.findByAge(age);
    }

    @PostMapping(value = "/persons/two")
    public void girlTwo(){
        personService.insertTwo();
    }
}
