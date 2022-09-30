package com.fttechexchange.accountservice.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fttechexchange.accountservice.entity.Wallets;
import com.fttechexchange.accountservice.entity.dtos.WalletWithAccountDto;

public interface WalletDao extends JpaRepository<Wallets,Integer> {
	//List<Wallets> getByAccount_AccountId(int accountId);
	@Query("From Wallets where account.account_id=:account_id and money_type=:money_type")
	List<Wallets> getByAccountIdAndByMoneyType(int account_id,int money_type);
	@Query("select new com.fttechexchange.accountservice.entity.dtos.WalletWithAccountDto"
			+ "(w.id,w.money_type,w.balance,a.customer_number) "
			+ "From Account a Inner Join a.wallets w")
	List<WalletWithAccountDto> getWalletWithAccountDtoDetails();

}
