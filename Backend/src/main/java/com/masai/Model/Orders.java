package com.masai.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
	private Integer OrderId;


	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> items = new ArrayList<>();
	private LocalDate createdDate;

	@ElementCollection
	@CollectionTable(name = "product_qty_mapping", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "OrderId") })
	@MapKeyColumn(name = "product_name")
	@Column(name = "qty")
	private Map<Product, Long> groupProduct;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "userId")
	private Customer customer;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "orderBillId")
	private OrderBill orderBill;
}
