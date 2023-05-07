package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@DiscriminatorValue("Admin")
public class Admin extends User {

//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Customer> customers=new ArrayList<>();
//	
//	@OneToMany(cascade =  CascadeType.ALL)
//	private List<Product> products =new ArrayList<>();
//		
	
}
