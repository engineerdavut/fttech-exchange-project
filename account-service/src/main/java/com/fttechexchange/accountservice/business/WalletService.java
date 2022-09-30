package com.fttechexchange.accountservice.business;

import java.util.List;



import com.fttechexchange.accountservice.core.utilities.results.DataResult;
import com.fttechexchange.accountservice.core.utilities.results.Result;

import com.fttechexchange.accountservice.entity.Wallets;
import com.fttechexchange.accountservice.entity.dtos.WalletWithAccountDto;


public interface WalletService {
	DataResult<List<Wallets>> getAll();
	Result add(Wallets wallet);
	DataResult<List<Wallets>> getAllSorted();
	//DataResult<List<Wallets>> getByAccountId(int account_id);
	
	DataResult<List<Wallets>> getByAccountIdAndByMoneyType(int account_id,int money_type);
	DataResult<List<WalletWithAccountDto>>getWalletWithAccountDtoDetails();
}
