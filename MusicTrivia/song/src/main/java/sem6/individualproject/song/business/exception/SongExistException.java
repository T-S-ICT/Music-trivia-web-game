package sem6.individualproject.song.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SongExistException extends ResponseStatusException {
    public SongExistException(){super(HttpStatus.BAD_REQUEST, "Song already exist by this artist");}
}
