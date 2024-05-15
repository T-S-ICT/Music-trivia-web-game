package sem6.individualproject.users.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class EmailExistException extends HttpStatusCodeException {
    public EmailExistException(){super(HttpStatus.BAD_REQUEST,"Email is already used.");}
}
