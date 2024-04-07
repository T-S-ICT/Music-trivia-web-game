package sem6.IndividualProject.MusicTrivia.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sem6.IndividualProject.MusicTrivia.business.SongService;
import sem6.IndividualProject.MusicTrivia.domain.song.CreateSongRequest;
import sem6.IndividualProject.MusicTrivia.domain.song.CreateSongResponse;
import sem6.IndividualProject.MusicTrivia.domain.song.GetAllSongResponse;
import sem6.IndividualProject.MusicTrivia.domain.song.Song;

import java.util.Optional;

@RestController
@RequestMapping("/songs")
@AllArgsConstructor
public class SongController {
    private final SongService songService;

    @PostMapping
    public ResponseEntity<CreateSongResponse> createSong(@RequestBody @Valid CreateSongRequest request){
        CreateSongResponse response = songService.createSong(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<GetAllSongResponse> getAllSong(){
        return ResponseEntity.ok(songService.getAllSong());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable int id){
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Song> getSong(@PathVariable(value = "id") final long id){
        final Optional<Song> songOptional = songService.getSong(id);
        if(songOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(songOptional.get());
    }
}
