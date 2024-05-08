package sem6.individualproject.song.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class InvalidSongException extends HttpStatusCodeException {
    public InvalidSongException(String err){super(HttpStatus.BAD_REQUEST,err);}
}
