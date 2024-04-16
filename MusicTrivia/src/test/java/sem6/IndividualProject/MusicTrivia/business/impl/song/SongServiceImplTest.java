package sem6.IndividualProject.MusicTrivia.business.impl.song;

import org.junit.jupiter.api.Test;
import sem6.IndividualProject.MusicTrivia.business.SongService;
import sem6.IndividualProject.MusicTrivia.domain.song.CreateSongRequest;
import sem6.IndividualProject.MusicTrivia.domain.song.CreateSongResponse;
import sem6.IndividualProject.MusicTrivia.persistence.entity.SongEntity;
import sem6.IndividualProject.MusicTrivia.persistence.impl.FakeSongRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class SongServiceImplTest {



    @Test
    void createSong_shouldCreateASong() {
        //Arrange
        SongService songService = new SongServiceImpl(new FakeSongRepositoryImpl());

        CreateSongRequest request = CreateSongRequest.builder().songName("Fat lip")
                .genre("Punk").artistName("Sum4").year("2000").build();

        SongEntity entity = SongEntity.builder().id(1L).songName("Fat lip").artistName("Sum4")
                .genre("Punk").year("2000").build();

        CreateSongResponse expected = CreateSongResponse.builder().id(1L).build();

        //Act
        CreateSongResponse actual = songService.createSong(request);

        //Assert
        assertEquals(expected,actual);
    }
}