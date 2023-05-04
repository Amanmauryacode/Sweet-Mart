package com.masai.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class SweetOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sweetOrderId")
	private Integer sweetOrderId;
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "sweetOrder")
	private List<SweetItem> items = new ArrayList<>();
	private LocalDate createdDate;
	
	private Map<Product,Long> groupProduct = new LinkedHashMap<>();
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "orderBillId")
	private OrderBill orderBill;
}
