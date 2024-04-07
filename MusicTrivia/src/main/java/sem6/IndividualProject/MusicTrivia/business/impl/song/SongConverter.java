package sem6.IndividualProject.MusicTrivia.business.impl.song;

import sem6.IndividualProject.MusicTrivia.domain.song.Song;
import sem6.IndividualProject.MusicTrivia.persistence.entity.SongEntity;

public class SongConverter {
    private SongConverter(){}

    public static Song convert(SongEntity songEntity){
        return Song.builder()
                .id(songEntity.getId())
                .songName(songEntity.getSongName())
                .artistName(songEntity.getArtistName())
                .genre(songEntity.getGenre())
                .year(songEntity.getYear())
                .build();
    }
}
