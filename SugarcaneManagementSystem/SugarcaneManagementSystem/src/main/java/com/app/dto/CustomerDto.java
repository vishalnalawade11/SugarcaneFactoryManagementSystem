package com.app.dto;

import com.app.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

	private String aadharNumber;

	private String customerName;

	private Product productName;

	private double productWeight;

	private double productRate;

	private double totalPrice;

	private double paidBalance;

	private double credit;
}
