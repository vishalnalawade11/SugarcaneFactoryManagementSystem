package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 12, max = 12)
	@Column(name = "aadhar_no", length = 12, unique = true)
	@Pattern(regexp = "\\d{12}", message = "Aadhar number must be exactly 12 digits")
	private String aadharNumber;

	@Column(name = "customer_name", length = 50)
	private String customerName;

	@Enumerated(EnumType.STRING)
	@Column(name = "product_name", nullable = false)
	private Product productName;

	@Column(name = "product_weight")
	private double productWeight;

	@Column(name = "product_rate")
	private double productRate;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "paid_money")
	private double paidBalance;

	private double credit;
}
