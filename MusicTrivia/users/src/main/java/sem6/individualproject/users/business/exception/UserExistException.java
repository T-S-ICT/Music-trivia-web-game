package sem6.individualproject.users.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class UserExistException extends HttpStatusCodeException {
    public UserExistException(){super(HttpStatus.IM_USED,"User already exist.");}
}
