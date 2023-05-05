
package com.masai.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class OrderBill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderBillId")
	private Integer orderBillId;
	private LocalDate createdDate;
	private Double totalCost;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "orderBill")
	private List<Orders> listSweetOrder = new ArrayList<>();
}
