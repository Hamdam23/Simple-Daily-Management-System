package net.guides.springboot.todomanagement.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    @Size(min = 4, message = "Enter at least 4 Characters...")
    private String name;
    @Size(min = 4, message = "Enter at least 4 Characters...")
    private String description;

    public Category() {
        super();
    }

    public Category(String name, String description, String userName) {
        super();
        this.name = name;
        this.description = description;
        this.userName = userName;
    }
    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
