package com.fttechexchange.accountservice.business;

import java.util.List;

import com.fttechexchange.accountservice.core.utilities.results.DataResult;
import com.fttechexchange.accountservice.core.utilities.results.Result;
import com.fttechexchange.accountservice.entity.Account;

public interface AccountService {
	DataResult<List<Account>> getAll();
	DataResult<List<Account>> getPegination(int page_no,int page_size);

	DataResult<Account> getById(int account_id);
	Result add(Account account);
}
