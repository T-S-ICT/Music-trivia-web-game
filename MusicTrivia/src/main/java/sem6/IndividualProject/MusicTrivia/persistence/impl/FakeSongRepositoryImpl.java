package sem6.IndividualProject.MusicTrivia.persistence.impl;

import org.springframework.stereotype.Repository;
import sem6.IndividualProject.MusicTrivia.persistence.SongRepository;
import sem6.IndividualProject.MusicTrivia.persistence.entity.SongEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class FakeSongRepositoryImpl implements SongRepository {
    private static long NEXT_ID = 1;
    private final List<SongEntity> savedSongEntities;

    public  FakeSongRepositoryImpl(){this.savedSongEntities = new ArrayList<>();
    }

    @Override
    public boolean existsById(long id) {
        return this.savedSongEntities
                .stream()
                .anyMatch(songEntity -> songEntity.getId() == id);
    }

    @Override
    public List<SongEntity> findAll() {
        return Collections.unmodifiableList(savedSongEntities);
    }

    @Override
    public Optional<SongEntity> findById(long id) {
        return this.savedSongEntities
                .stream()
                .filter(songEntity -> songEntity.getId().equals(id))
                .findFirst();
    }

    @Override
    public SongEntity save(SongEntity songEntity) {
        if(songEntity.getId() == null){
            songEntity.setId(NEXT_ID);
            NEXT_ID++;
            this.savedSongEntities.add(songEntity);
        }
        return songEntity;
    }

    @Override
    public void deleteById(long id) {
        this.savedSongEntities.removeIf(songEntity -> songEntity.getId().equals(id));
    }
}
