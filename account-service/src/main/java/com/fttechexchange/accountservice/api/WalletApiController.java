package com.fttechexchange.accountservice.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fttechexchange.accountservice.business.WalletService;
import com.fttechexchange.accountservice.core.utilities.results.DataResult;
import com.fttechexchange.accountservice.core.utilities.results.Result;
import com.fttechexchange.accountservice.entity.Wallets;
import com.fttechexchange.accountservice.entity.dtos.WalletWithAccountDto;
import com.fttechexchange.accountservice.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping("/wallet")
public class WalletApiController {
	public WalletService walletService;
	

	@Autowired
	public WalletApiController(WalletService walletService) {
		super();
		this.walletService = walletService;
	}
	@GetMapping("/getall")
	public DataResult<List<Wallets>> getAll(){
		return this.walletService.getAll();
		
	}
	@PostMapping("/add")
	public Result add(@RequestBody Wallets wallet) {
		return new Result(true,"eklendi.");
	}
	/*
	@GetMapping("/getByAccountId")
	public DataResult<List<Wallets>> getByAccountId(@RequestParam int account_id) {
		// TODO Auto-generated method stub
		return this.walletService.getByAccountId(account_id);
	}
	*/
	@GetMapping("/getByAccountIdAndByMoneyType")
	public DataResult<List<Wallets>> getByAccountIdAndByMoneyType(@RequestParam("account_id") int account_id,@RequestParam("money_type") int money_type){
		return this.walletService.getByAccountIdAndByMoneyType(account_id, money_type);
	}
	@GetMapping("/getSorted")
	DataResult<List<Wallets>> getSorted() {
		// TODO Auto-generated method stub
		return this.walletService.getAllSorted();
	}
	@GetMapping("/getWalletWithAccountDtoDetails")
	public DataResult<List<WalletWithAccountDto>> getWalletWithAccountDtoDetails(){
		return this.walletService.getWalletWithAccountDtoDetails();
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handlerValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors=new HashMap<String,String>();
		for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors=new ErrorDataResult<Object>
			(validationErrors,"dogrulama hatalari");
		return errors;
	}
}
