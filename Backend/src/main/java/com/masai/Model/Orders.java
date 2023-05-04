package com.masai.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sweetOrderId")
	private Integer sweetOrderId;
	@ManyToOne
	private User user;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> items = new ArrayList<>();
	private LocalDate createdDate;

	@ElementCollection
	@CollectionTable(name = "product_qty_mapping", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "sweetOrderId") })
	@MapKeyColumn(name = "product_name")
	@Column(name = "qty")
	private Map<Product, Long> groupProduct;

	@ManyToOne
	@JoinColumn(name = "userId")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "orderBillId")
	private OrderBill orderBill;
}
