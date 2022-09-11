package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "blogs")
@Data
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blog_id")
	private int id;
	
	@Column(name = "blog_title")
	private String title;
	
	@Column(name = "blog_subject")
	private String subject;
	
	@Column(name = "blog_body")
	private String body;
	
	@Column(name = "blog_categories")
	private String[] categories;
	
	public Blog() {
		super();
	}

	public Blog(int id, String title, String subject, String body, String[] categories) {
		super();
		this.id = id;
		this.title = title;
		this.subject = subject;
		this.body = body;
		this.categories = categories;
	}

	public Blog(String title, String subject, String body, String[] categories) {
		super();
		this.title = title;
		this.subject = subject;
		this.body = body;
		this.categories = categories;
	}
}
