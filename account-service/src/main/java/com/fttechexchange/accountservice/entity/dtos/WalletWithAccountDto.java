package com.fttechexchange.accountservice.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletWithAccountDto {
	private int id;
	private int money_type;
	private double balance;
	private String customer_number;

}
