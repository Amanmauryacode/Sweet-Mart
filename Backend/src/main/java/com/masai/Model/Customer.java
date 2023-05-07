package com.masai.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Customer")
public class Customer extends User{

	@JsonProperty(access = Access.READ_ONLY)
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private Set<Orders> orders = new HashSet<>();
	
	@JsonProperty(access = Access.READ_ONLY)
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
	private Cart cart;

}
