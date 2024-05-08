package sem6.individualproject.song.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sem6.individualproject.song.persistence.entity.GenreEnum;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSongRequest {
    private Long id;
    private String songName;
    private String artistName;
    private GenreEnum genre;
    private String year;
}
