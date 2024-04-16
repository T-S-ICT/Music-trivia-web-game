package sem6.IndividualProject.MusicTrivia.business.impl.song;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem6.IndividualProject.MusicTrivia.business.SongService;
import sem6.IndividualProject.MusicTrivia.domain.song.*;
import sem6.IndividualProject.MusicTrivia.persistence.SongRepository;
import sem6.IndividualProject.MusicTrivia.persistence.entity.SongEntity;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {
private final SongRepository songRepository;


    /**
     * Create Song
     * @param request
     * @return song id
     *
     * @should Create a song
     */
    @Override
    public CreateSongResponse createSong(CreateSongRequest request) {
        SongEntity newSong = SongEntity.builder()
                .songName(request.getSongName())
                .artistName(request.getArtistName())
                .genre(request.getGenre())
                .year(request.getYear())
                .build();

        SongEntity savedSong = songRepository.save(newSong);

        return CreateSongResponse.builder()
                .id(savedSong.getId())
                .build();
    }

    @Override
    public GetAllSongResponse getAllSong() {
        List<Song> songs = songRepository.findAll()
                .stream()
                .map(SongConverter::convert)
                .toList();

        return GetAllSongResponse.builder()
                .getAllSong(songs)
                .build();
    }

    @Override
    public void deleteSong(long id) {
        songRepository.deleteById(id);
    }

    @Override
    public Optional<Song> getSong(long id) {
        return songRepository.findById(id).map(SongConverter::convert);
    }

    @Override
    public void updateSong(UpdateSongRequest request) {
        //Not implement yet
    }
}
