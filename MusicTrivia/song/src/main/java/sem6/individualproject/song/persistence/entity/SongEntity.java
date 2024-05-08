package sem6.individualproject.song.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "song")
@Entity
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "song_name")
    private String songName;

    @NotBlank
    @Column(name = "artist_name")
    private String artistName;

    @NotNull
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private GenreEnum genre;

    @NotNull
    @Column(name = "publish_year")
    private LocalDateTime year;
}
