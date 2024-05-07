package sem6.individualproject.song.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import sem6.individualproject.song.persistence.entity.SongGenreEntity;

public interface SongGenreRepository extends JpaRepository<SongGenreEntity,Long> {
}
