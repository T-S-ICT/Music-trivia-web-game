package sem6.individualproject.song.business.impl;

import sem6.individualproject.song.domain.Song;
import sem6.individualproject.song.persistence.entity.SongEntity;

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
