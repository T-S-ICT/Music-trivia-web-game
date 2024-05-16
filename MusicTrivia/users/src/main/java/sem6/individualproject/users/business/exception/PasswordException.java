package sem6.individualproject.users.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PasswordException extends ResponseStatusException {
    public PasswordException(String err){super(HttpStatus.BAD_REQUEST,err);}
}
