package sem6.IndividualProject.MusicTrivia.domain.song;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSongRequest {
    private Long id;
    private String songName;
    private String artistName;
    private String genre;
    private String year;
}
