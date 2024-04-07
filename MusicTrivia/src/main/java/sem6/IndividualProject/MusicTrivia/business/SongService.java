package sem6.IndividualProject.MusicTrivia.business;

import sem6.IndividualProject.MusicTrivia.domain.song.*;

import java.util.Optional;

public interface SongService {
    CreateSongResponse createSong(CreateSongRequest request);
    GetAllSongResponse getAllSong();
    void deleteSong(long id);
    Optional<Song> getSong(long id);
    void updateSong(UpdateSongRequest request);
}
