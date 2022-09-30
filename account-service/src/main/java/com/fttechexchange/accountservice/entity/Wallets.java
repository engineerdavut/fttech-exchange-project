package com.fttechexchange.accountservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="wallets")
@JsonIgnoreProperties({"hibernateLazyInitialier","handler","account"})
public class Wallets {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="money_type")
	private int money_type;
	@Column(name="wallet_name")
	private String wallet_name;
	@Column(name="balance")
	private double balance;
	@Column(name="wallet_passwd")
	private String wallet_passwd;
	@ManyToOne()
	@JoinColumn(name="account_id")
	private Account account;
}
