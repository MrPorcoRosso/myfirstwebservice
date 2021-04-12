package com.example.myfirstwebservice.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 *@author aristotle miranda
 *@version 1.0
 *@since January 1, 1970
 *	<ul>
 * <li>This is one</li>
 * <li>This is two</li>
 * </ul>
 * <p>This is a sample paragraph. This is the entity for the table Person in my first
 * web service. </p>
 **/


@Entity
@Table(name = "Person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	 /**
	 * DTO 
	 * 
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String lastName;
	
	@Column
	private String address;
	
	//getter-setter SHIFT+ALT+S
	
	 /**
	  * Getter for the id field
	  * @return id
	  * */	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
