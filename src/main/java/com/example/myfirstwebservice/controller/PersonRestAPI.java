package com.example.myfirstwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.myfirstwebservice.entity.Person;
import com.example.myfirstwebservice.exception.CustomException;
import com.example.myfirstwebservice.service.PersonRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/record")
@Api(value = "Person Rest Controller")
public class PersonRestAPI {
	
	@Autowired
	PersonRecordService service;
	
	///http://localhost:8080/record/person/id
	@GetMapping("/person/{id}")
	@ApiOperation(value = "Get Person Information", response = Person.class, notes = "Returns a single record of Person table.")
	public Person getPersonInfo(@ApiParam(value = "This is the primary id of the record.") @PathVariable("id") int id) throws Exception {
		Person person = service.getPersonInfo(id);
		return person;		
	}
	
	//insert record into the table
	@PostMapping("/person")	
	public Person savePersonInfo(@RequestBody Person person) {
		return service.savePersonInfo(person);
	} 
	
	@PutMapping("/person")	
	public Person updatePersonInfo(@RequestBody Person person) {
		return service.updatePersonInfo(person);
	} 
	
	//http://localhost:8080/record/person?id={person.id}
	@DeleteMapping("/person")	
	public String deletePersonInfo(@RequestParam int id) throws CustomException{
		return service.deletePersonInfo(id);
	} 
}
