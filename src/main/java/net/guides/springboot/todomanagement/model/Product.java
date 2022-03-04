package net.guides.springboot.todomanagement.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Size(min = 4, message = "Enter at least 4 Characters...")
	private String name;
	@Size(min = 4, message = "Enter at least 4 Characters...")
	private String category;
	@Size(min = 4, message = "Enter at least 4 Characters...")
	private String description;

	private Date timestamp;

	public Product() {
		super();
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	private String userName;

	public Product(String name, String category, String description, String userName, Date timestamp) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.userName = userName;
		this.timestamp = timestamp;
	}
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}