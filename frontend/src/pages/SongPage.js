import CreateSong from "../components/CreateSong";
import GetAllSong from "../components/GetAllSong";
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