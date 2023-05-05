package com.masai.Model;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private Integer productId;
	@Size(min = 5,max = 20,message = "Enter Valid Name")
	@NotNull(message = "Product Name Mandatory")
    @NotEmpty(message = "Provide some valid ProductName")
	private String productName;
	@Size(min = 5,max = 100,message = "Enter Valid image")
	@NotNull(message = "Product image Mandatory")
    @NotEmpty(message = "Provide some valid image")
	private String image;
	@NotBlank(message = "Price should not be blank")
    @NotEmpty(message = "Provide some valid price")
	@Min(value = 10,message = "Minimum Price should be 10")
	private double price;
	@Size(min = 10,max = 30,message = "Enter Valid description")
	@NotNull(message = "Description description Mandatory")
    @NotEmpty(message = "Provide some valid description")
	private String description;
	@AssertFalse
	private boolean isAvailable;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
}





