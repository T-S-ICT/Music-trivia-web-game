package sem6.individualproject.song.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import sem6.individualproject.song.persistence.entity.SongEntity;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<SongEntity, Long> {
    boolean existsBySongNameAndAndArtistName(String songName, String artistName);
}
