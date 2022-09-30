package com.fttechexchange.buysellservice.business;

import java.util.List;

import com.fttechexchange.buysellservice.core.utilities.results.DataResult;
import com.fttechexchange.buysellservice.core.utilities.results.Result;
import com.fttechexchange.buysellservice.entity.Exchange;



public interface ExchangeService {
	DataResult<List<Exchange>> getAll();
	DataResult<List<Exchange>> getPegination(int page_no,int page_size);

	DataResult<Exchange> getById(int id);
	Result add(Exchange exchange);
}
