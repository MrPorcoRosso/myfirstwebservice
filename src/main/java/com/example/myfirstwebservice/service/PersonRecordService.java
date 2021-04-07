package com.example.myfirstwebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myfirstwebservice.controller.model.MessageType;
import com.example.myfirstwebservice.dao.PersonDAOImpl;
import com.example.myfirstwebservice.entity.Person;
import com.example.myfirstwebservice.exception.CustomException;

@Service
public class PersonRecordService {

	@Autowired
	PersonDAOImpl personDAOImpl;

	public Person getPersonInfo(int id) throws CustomException {		
		return personDAOImpl.getPersonInfo(id);
	}

	// Create
	public Person savePersonInfo(Person person) {
		// persist means insert record into the table		
		return personDAOImpl.savePersonInfo(person);
	}

	// Update
	public Person updatePersonInfo(Person person) {		
		return personDAOImpl.updatePersonInfo(person);
	}

	// Delete
	public String deletePersonInfo(int id) throws CustomException {
		Person person = null;
		try {
			person = getPersonInfo(id);
		} catch (CustomException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			throw e;
			//throw new CustomException(MessageType.RECORD_NOT_FOUND.getCode());
		}
		
		return personDAOImpl.deletePersonInfo(id);
	}
}
