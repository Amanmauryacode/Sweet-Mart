package com.masai.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Customer extends User{

//	private Long userId;
	private String userName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private Set<SweetOrder> sweetOrders = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private List<SweetItem> sweetItems = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")

	private Cart cart;

}
