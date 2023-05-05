package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartId")
	private Long cartId;
	private Double grandTotal,total;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId")
	private List<Product> listProduct = new ArrayList<>();

	private Integer productCount;
	@OneToOne
    @PrimaryKeyJoinColumn
	private Customer customer;
}
