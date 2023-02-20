package com.yixuan.receiptProcess.receiptProcess.Receipt;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ReceiptNotFoundException extends RuntimeException {
	
	public ReceiptNotFoundException(String message) {
		super(message);
	}

}