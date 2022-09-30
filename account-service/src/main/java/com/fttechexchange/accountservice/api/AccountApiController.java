package com.fttechexchange.accountservice.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fttechexchange.accountservice.entity.Account;
import com.fttechexchange.accountservice.business.AccountService;
import com.fttechexchange.accountservice.core.utilities.results.DataResult;
import com.fttechexchange.accountservice.core.utilities.results.ErrorDataResult;
import com.fttechexchange.accountservice.core.utilities.results.Result;
import com.fttechexchange.accountservice.core.utilities.results.SuccessDataResult;


@RestController
@RequestMapping("/account")
public class AccountApiController {
	
	public AccountService accountService;
	@Autowired
	public AccountApiController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	@GetMapping("/getall")
	public DataResult<List<Account>> getAll(){
		return this.accountService.getAll();
		
	}
	@PostMapping("/add") //ResponseEntity<Result> fakat sonuc belli degil.
	public ResponseEntity<?> add(@Valid @RequestBody Account account) {
		return ResponseEntity.ok(accountService.add(account));
	}
	@GetMapping("/get/{id}")
	public DataResult<Account> get(@PathVariable("id") int id){
		return this.accountService.getById(id);
		
	}
	@GetMapping("/getPegination")
	DataResult<List<Account>> getPegination(@RequestParam("page_no") int page_no,@RequestParam("page_size")int page_size) {
		// TODO Auto-generated method stub
		return this.accountService.getPegination(page_no, page_size);
	}
	public ResponseEntity<Account> save(Account account){
		return null;
	}
	public ResponseEntity<Account> update(Account account){
		return null;
	}
	public ResponseEntity<Account> delete(int id){
		return null;
	}
	public ResponseEntity<Account> pagination(){
		return null;
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
