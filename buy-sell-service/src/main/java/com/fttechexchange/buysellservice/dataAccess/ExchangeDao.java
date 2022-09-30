package com.fttechexchange.buysellservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fttechexchange.buysellservice.entity.Exchange;

public interface ExchangeDao extends JpaRepository<Exchange,Integer> {

}
