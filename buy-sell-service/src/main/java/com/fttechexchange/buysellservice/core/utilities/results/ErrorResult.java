package com.fttechexchange.buysellservice.core.utilities.results;

public class ErrorResult extends Result {
	public ErrorResult() {
		super(false);
	}
	public ErrorResult( String message) {
		super(false, message);
		// TODO Auto-generated constructor stub
	}
}