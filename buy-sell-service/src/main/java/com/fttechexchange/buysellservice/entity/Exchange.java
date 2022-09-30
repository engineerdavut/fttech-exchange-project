package com.fttechexchange.buysellservice.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="exchange")
public class Exchange {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="exchange_date")
	private Date exchange_date;
	@Column(name="sold_money_type")
	private int sold_money_type;
	@Column(name="received_money_type")
	private int received_money_type;
	@Column(name="definition")
	private String definition;
	@Column(name="ratio")
	private double ratio;
	@Column(name="quantity")
	private double quantity;
}
