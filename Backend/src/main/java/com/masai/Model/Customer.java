package com.masai.Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("Customer")
public class Customer extends User{

	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private Set<Orders> orders = new HashSet<>();
	
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
	private Cart cart;

}
