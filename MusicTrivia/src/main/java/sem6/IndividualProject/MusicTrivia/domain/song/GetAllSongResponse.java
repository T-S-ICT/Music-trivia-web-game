package sem6.IndividualProject.MusicTrivia.domain.song;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSongResponse {
    private List<Song> getAllSong;
}
