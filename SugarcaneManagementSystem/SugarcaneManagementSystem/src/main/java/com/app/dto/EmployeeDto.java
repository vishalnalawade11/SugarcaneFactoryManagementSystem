package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	private String aadharNumber;

	private LocalDate paymentDate;

	private Double paymentAmount;

	private String accountNumber;

	private String ifscCode;
}
