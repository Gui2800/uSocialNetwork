/*
 *
 * IFPE - Federal Institute of Education, Science and Technology of Pernambuco
 * Informatics for the Internet
 * Object Oriented Programming
 * Professor: Allan Lima - allan.lima@igarassu.ifpe.edu.br
 * 
 * Public domain code, feel free to use, modify and redistribute it 
 *
 */

package br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.user;

import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.Entity;

/**
 * 
 * Represents an user on the social network 
 * 
 * @author Allan Diego Silva Lima - allan.lima@igarassu.ifpe.edu.br
 *
 */
public class User extends Entity{
	// the name of the user
	private String name;
	// the passord of the user
	private String password;
	// the email of the user
	private String email;
	// the phone of the user
	private String phone;

	/**
	 * 
	 * Initializes the classe's parameters with the given parameters 
	 * 
	 * @param id the id the of user
	 * @param name the name of the user
	 * @param password the password of the user
	 */
	public User(long id, String name, String password, String email, String phone) {
		super(id);
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * 
	 * Returns the name of the user
	 * 
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Sets the name of the user
	 * 
	 * @param name the new name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Returns the password of the user
	 * 
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * Sets the password of the user
	 * 
	 * @param password the new password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
