package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

	@Autowired
	private PersonService personService;

	@Test
	public void findoneTest() {
		Person person = personService.findOne(1);
		System.out.println(person);
	}
}
