package com.masai.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@DiscriminatorValue("Admin")
public class Admin extends User {
	
	

}
