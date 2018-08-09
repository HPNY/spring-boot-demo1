package com.example.demo.service;

import com.example.demo.repository.PersonRepository;
import com.example.demo.domain.Person;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.PersonException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Transactional // 事务注解
	public void insertTwo() {
		Person person1 = new Person();
		person1.setName("C");
		person1.setAge(19);
		personRepository.save(person1);

		Person person2 = new Person();
		person2.setName("D");
		person2.setAge(21);
		personRepository.save(person2);
	}

	public void getAge(Integer id) throws Exception {
		Person person = personRepository.getOne(id);
		Integer age = person.getAge();
		if (age < 10) {
			throw new PersonException(ResultEnum.PRIMARY_SCHOOL);
		} else if (age < 16) {
			throw new PersonException(ResultEnum.MIDDLE_SCHOOL);
		}
	}
	
	/**
	 * 通过ID查询一个person的信息
	 * @param id
	 * @return
	 */
	public Person findOne(Integer id) {
		return personRepository.getOne(id);
	}
}
