package sem6.individualproject.song.business;

import sem6.individualproject.song.domain.*;

import java.util.Optional;

public interface SongService {
    CreateSongResponse createSong(CreateSongRequest request);
    GetAllSongResponse getAllSong();
    void deleteSong(long id);
    Optional<Song> getSong(long id);
    void updateSong(UpdateSongRequest request);
}
