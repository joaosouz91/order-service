package br.com.fiap.orderservice.exception;

public class OrderNotFoundException extends Exception {
	
	public OrderNotFoundException(Class<?> clazz, String... searchParamsMap) {
        super(Exceptions.generateMessage(clazz.getSimpleName(), Exceptions.toMap(String.class, String.class, searchParamsMap)));
    }

}
