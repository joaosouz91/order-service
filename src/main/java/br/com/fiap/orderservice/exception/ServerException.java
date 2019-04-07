package br.com.fiap.orderservice.exception;

public class ServerException extends Exception {

	public ServerException(String... searchParamsMap) {
		super("Internal server error " + Exceptions.toMap(String.class, String.class, searchParamsMap));
	}
}