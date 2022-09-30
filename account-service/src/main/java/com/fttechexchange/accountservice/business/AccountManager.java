package com.fttechexchange.accountservice.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fttechexchange.accountservice.core.utilities.results.DataResult;
import com.fttechexchange.accountservice.core.utilities.results.Result;
import com.fttechexchange.accountservice.core.utilities.results.SuccessDataResult;
import com.fttechexchange.accountservice.core.utilities.results.SuccessResult;
import com.fttechexchange.accountservice.dataAccess.AccountDao;
import com.fttechexchange.accountservice.entity.Account;
@Service
public class AccountManager implements AccountService {
	private AccountDao accountDao;
	@Autowired //bagimlilik olusturur.
	public AccountManager(AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}

	@Override
	public DataResult<Account> getById(int account_id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Account>(this.accountDao.getOne(account_id),"hesap listelendi.");
	}
	@Override
	public DataResult<List<Account>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Account>>(this.accountDao.findAll(),"hesaplar listelendi.");
	}
	@Override
	public Result add(Account account) {
		// TODO Auto-generated method stub
		return new SuccessDataResult(this.accountDao.save(account),"kullanici kaydoldu.");
	}

	@Override
	public DataResult<List<Account>> getPegination(int page_no, int page_size) {
		// TODO Auto-generated method stub
		Pageable pageable=PageRequest.of(page_no-1,page_size);
		return new SuccessDataResult<List<Account>>(this.accountDao.findAll(pageable).getContent());
	}


}
