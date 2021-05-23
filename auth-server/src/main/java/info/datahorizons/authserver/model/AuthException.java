package info.datahorizons.authserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthException extends RuntimeException{

	private static final long serialVersionUID = -5067913166715145328L;

	private Type type;
	
	public static enum Type{
		WRONG_PASS, INVALID_EMAIL, EMAIL_ALREADY_EXISTS, USER_NOT_FOUND, PASS_REQUIRED}
	
	public AuthException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthException(String message, Type type) {
		super(message);
		this.type = type;
	}

	public AuthException(Throwable cause) {
		super(cause);
	}

	
}
