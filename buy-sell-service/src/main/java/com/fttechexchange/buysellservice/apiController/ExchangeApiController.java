package com.fttechexchange.buysellservice.apiController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

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

import com.fttechexchange.buysellservice.business.ExchangeService;
import com.fttechexchange.buysellservice.core.utilities.results.DataResult;
import com.fttechexchange.buysellservice.core.utilities.results.ErrorDataResult;
import com.fttechexchange.buysellservice.entity.Exchange;




@RestController
@RequestMapping("/exchange")
public class ExchangeApiController {
	
	public ExchangeService exchangeService;
	@Autowired
	public ExchangeApiController(ExchangeService exchangeService) {
		super();
		this.exchangeService = exchangeService;
	}
	@GetMapping("/getall")
	public DataResult<List<Exchange>> getAll(){
		return this.exchangeService.getAll();
		
	}
	@PostMapping("/add") //ResponseEntity<Result> fakat sonuc belli degil.
	public ResponseEntity<?> add(@Valid @RequestBody Exchange exchange) {
		return ResponseEntity.ok(exchangeService.add(exchange));
	}
	@GetMapping("/get/{id}")
	public DataResult<Exchange> get(@PathVariable("id") int id){
		return this.exchangeService.getById(id);
		
	}
	@GetMapping("/getPegination")
	DataResult<List<Exchange>> getPegination(@RequestParam("page_no") int page_no,@RequestParam("page_size")int page_size) {
		// TODO Auto-generated method stub
		return this.exchangeService.getPegination(page_no, page_size);
	}
	public ResponseEntity<Exchange> save(Exchange exchange){
		return null;
	}
	public ResponseEntity<Exchange> update(Exchange exchange){
		return null;
	}
	public ResponseEntity<Exchange> delete(int id){
		return null;
	}
	public ResponseEntity<Exchange> pagination(){
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

