package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 12, max = 12)
	@Column(name = "aadhar_no", length = 12, unique = true)
	@Pattern(regexp = "\\d{12}", message = "Aadhar number must be exactly 12 digits")
	private String aadharNumber;

	@NotNull
	@Column(name = "payment_date")
	private LocalDate paymentDate;

	@NotNull
	@Column(name = "payment_amount")
	private Double paymentAmount;

	@NotBlank
	@Column(name = "account_number", length = 20)
	private String accountNumber;

	@NotBlank
	@Column(name = "ifsc_code", length = 11)
	private String ifscCode;
}
