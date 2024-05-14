package sem6.individualproject.users.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class PasswordException extends HttpStatusCodeException {
    public PasswordException(String err){super(HttpStatus.NOT_FOUND,err);}
}
