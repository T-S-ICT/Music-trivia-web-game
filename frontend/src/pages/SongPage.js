import CreateSong from "../components/Song/CreateSong";
import GetAllSong from "../components/Song/GetAllSong";
import "../css/Spacing.css";

function SongPage() {

    return (
        <div className="topSpace">
            <CreateSong />
            <GetAllSong />
        </div>
    );
}

export default SongPage;