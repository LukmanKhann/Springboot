package org.jsp.userapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue
private int id;
private String name;
private String brand;
private String catagory;
private double cost;
private String image;
@ManyToOne
@JoinColumn(name = "user_id")
@JsonIgnore
private User users;
}
