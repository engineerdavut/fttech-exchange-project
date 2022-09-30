package com.fttechexchange.accountservice.business;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fttechexchange.accountservice.core.utilities.results.DataResult;
import com.fttechexchange.accountservice.core.utilities.results.Result;
import com.fttechexchange.accountservice.core.utilities.results.SuccessDataResult;
import com.fttechexchange.accountservice.core.utilities.results.SuccessResult;
import com.fttechexchange.accountservice.dataAccess.WalletDao;
import com.fttechexchange.accountservice.entity.Wallets;
import com.fttechexchange.accountservice.entity.dtos.WalletWithAccountDto;
@Service
public class WalletManager implements WalletService {
	private WalletDao walletDao;
	public WalletManager(WalletDao walletDao) {
		super();
		this.walletDao = walletDao;
	}
	@Override
	public DataResult<List<Wallets>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Wallets>>(this.walletDao.findAll(),"cuzdanlar listelendi.");
	}

	@Override
	public Result add(Wallets wallet) {
		// TODO Auto-generated method stub
		return new SuccessResult("cuzdan olusturuldu.");
	}
	/*
	@Override
	public DataResult<List<Wallets>> getByAccountId(int account_id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Wallets>>(this.walletDao.getByAccount_AccountId(account_id),"cüzdanlar listelendi.");
	}
*/
	@Override
	public DataResult<List<Wallets>> getByAccountIdAndByMoneyType(int account_id, int money_type) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Wallets>>(this.walletDao.getByAccountIdAndByMoneyType(account_id, money_type),"cüzdanlar listelendi.");
	}
	@Override
	public DataResult<List<Wallets>> getAllSorted() {
		// TODO Auto-generated method stub
		Sort sort=	Sort.by(Sort.Direction.DESC,"balance");
		return new SuccessDataResult<List<Wallets>>(this.walletDao.findAll(sort),"siralandi.");
	
	}
	@Override
	public DataResult<List<WalletWithAccountDto>> getWalletWithAccountDtoDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<WalletWithAccountDto>>(this.walletDao.getWalletWithAccountDtoDetails(),"cüzdanlar listelendi.");
	}



}
