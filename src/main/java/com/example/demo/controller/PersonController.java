package com.example.demo.controller;

import com.example.demo.repository.PersonRepository;
import com.example.demo.domain.Person;
import com.example.demo.domain.Result;
import com.example.demo.service.PersonService;
import com.example.demo.utils.ResultUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

	private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonService personService;

	/**
	 * 查询所有person列表
	 * 
	 * @return
	 */
	@GetMapping(value = "/persons")
	public List<Person> personList() {
		return personRepository.findAll();
	}

	/**
	 * 添加一个person
	 * 
	 * @param person
	 * @return
	 */
	@PostMapping(value = "/persons")
	public Result<Person> personAdd(@Valid Person person, BindingResult bindingResult) {
		Result<Person> result = new Result<Person>();
		if (bindingResult.hasErrors())
			return null;
//			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		return ResultUtil.success(personRepository.save(person));
	}

	/**
	 * 根据ID查询person
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/persons/{id}")
	public Person personFindOne(@PathVariable("id") Integer id) {
		return personRepository.findById(id).orElse(null);
	}

	/**
	 * 根据ID更新person
	 * 
	 * @param id
	 * @param name
	 * @param age
	 * @return
	 */
	@PutMapping(value = "/persons/{id}")
	public Person personUpdate(@PathVariable("id") Integer id, @RequestParam("name") String name,
			@RequestParam("age") Integer age) {
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setAge(age);
		return personRepository.save(person);
	}

	/**
	 * 根据ID删除person
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "/persons/{id}")
	public void personDelete(@PathVariable("id") Integer id) {
		personRepository.deleteById(id);
	}

	/**
	 * 根据年龄查询person列表
	 * 
	 * @param age
	 * @return
	 */
	@GetMapping(value = "/persons/age/{age}")
	public List<Person> personListByAge(@PathVariable("age") Integer age) {
		return personRepository.findByAge(age);
	}

	@PostMapping(value = "/persons/two")
	public void personTwo() {
		personService.insertTwo();
	}

	@GetMapping(value = "/persons/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception {
		personService.getAge(id);
	}
}
