import { useState, useEffect } from "react";
import axios from 'axios';

function SongPage(){
    const[songs, setSongs] = useState([])

    const fetchSongs = async () => {
        try{
            const response = await axios.get('http://localhost:8080/songs');
            console.log(response.data.getAllSong)
            setSongs(response.data.getAllSong)
        }
        catch(err){
            console.log(err)
        }
    }

    useEffect(() =>{
        fetchSongs();
    },[]);

    const s = songs.map((song, id) =>{
        return <div key={id}>
        <h3>{song.songName}</h3>
        <p>By {song.artistName}</p>
        <p>From {song.year}</p>
        </div>
    })

    return(
        <>
            {s}
        </>
    );
}

export default SongPage;