package com.fttechexchange.buysellservice.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fttechexchange.buysellservice.core.utilities.results.DataResult;
import com.fttechexchange.buysellservice.core.utilities.results.Result;
import com.fttechexchange.buysellservice.core.utilities.results.SuccessDataResult;
import com.fttechexchange.buysellservice.dataAccess.ExchangeDao;
import com.fttechexchange.buysellservice.entity.Exchange;
@Service
public class ExchangeManager implements ExchangeService{
	private ExchangeDao exchangeDao;
	@Autowired
	public ExchangeManager(ExchangeDao exchangeDao) {
		super();
		this.exchangeDao = exchangeDao;
	}

	@Override
	public DataResult<List<Exchange>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Exchange>>(this.exchangeDao.findAll(),"hesaplar listelendi.");
	}

	@Override
	public DataResult<List<Exchange>> getPegination(int page_no, int page_size) {
		// TODO Auto-generated method stub
		Pageable pageable=PageRequest.of(page_no-1,page_size);
		return new SuccessDataResult<List<Exchange>>(this.exchangeDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<Exchange> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Exchange>(this.exchangeDao.getOne(id),"alışveriş listelendi.");
	}

	@Override
	public Result add(Exchange exchange) {
		// TODO Auto-generated method stub
		return new SuccessDataResult(this.exchangeDao.save(exchange),"alışveriş kaydoldu.");
	}

}
