package sem6.individualproject.song.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem6.individualproject.song.business.SongService;
import sem6.individualproject.song.business.exception.SongExistException;
import sem6.individualproject.song.domain.*;
import sem6.individualproject.song.persistence.SongRepository;
import sem6.individualproject.song.persistence.entity.GenreEnum;
import sem6.individualproject.song.persistence.entity.SongEntity;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;


    @Override
    public CreateSongResponse createSong(CreateSongRequest request) {
        if(songRepository.existsBySongNameAndAndArtistName(request.getSongName(), request.getArtistName())){
            throw new SongExistException();
        }

        SongEntity newSong = SongEntity.builder()
                .songName(CapitalizeEachWord(request.getSongName().split(" ")))
                .artistName(CapitalizeEachWord(request.getArtistName().split(" ")))
                .genre(request.getGenre())
                .year(request.getYear())
                .build();

        SongEntity savedSong = songRepository.save(newSong);

        return CreateSongResponse.builder()
                .id(savedSong.getId())
                .build();
    }

    private String CapitalizeEachWord(String[] words){
        //Capitalize each part of the words in the song
        StringBuilder titleBuilder = new StringBuilder();
        for (String word: words){
            //Capitalize the first letter of the word
            titleBuilder.append(Character.toUpperCase(word.charAt(0)) + word.substring(1)).append(" ");
        }
        String title = titleBuilder.toString().trim();
        return title;
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
        //Not yet implemented
    }
}
