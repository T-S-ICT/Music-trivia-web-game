package sem6.IndividualProject.MusicTrivia.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongEntity {
    private Long id;
    private String songName;
    private String artistName;
    private String genre;
    private String year;
}
