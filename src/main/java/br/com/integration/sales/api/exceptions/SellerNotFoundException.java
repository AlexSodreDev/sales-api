package br.com.integration.sales.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Seller Not Found")
public class SellerNotFoundException extends Exception {

};
