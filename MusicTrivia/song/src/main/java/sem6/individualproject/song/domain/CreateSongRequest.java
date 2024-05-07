package sem6.individualproject.song.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSongRequest {
    private String songName;
    private String artistName;
    private String genre;
    private LocalDateTime year;
}
