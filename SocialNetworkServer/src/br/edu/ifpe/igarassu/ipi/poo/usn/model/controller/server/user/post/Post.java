/*
 * 
 * Post is a class responsible for treatment of data post
 * 
 * */
package br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.post;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.igarassu.ipi.poo.usn.data.access.arraylist.ArrayListDAO;

public class Post extends PostArrayListDAO{
	private String name;
	private int id;
	private String text;
	private int likes;
	ArrayList<String> coments = new ArrayList<String>();
	
	public Post(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}
	
	/*
	 * Id for store data in JSON
	 * */
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}

	/*
	 * Text it's a post in feed  
	 * */
	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return this.text;
	}
	
	/*
	 * Each post have likes
	 * */
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getLikes() {
		return this.likes;
	}

	
	
}
