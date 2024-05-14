package sem6.individualproject.users.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class InvalidUsersException extends HttpStatusCodeException {
    public InvalidUsersException(String err){super(HttpStatus.BAD_REQUEST,err);}
}
