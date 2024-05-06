package sem6.individualproject.song.persistence;

import sem6.individualproject.song.persistence.entity.SongEntity;

import java.util.List;
import java.util.Optional;

public interface SongRepository {
    boolean existsById(long id);

    List<SongEntity> findAll();

    Optional<SongEntity> findById(long id);

    SongEntity save(SongEntity songEntity);

    void deleteById(long id);
}
