import { useState, useEffect } from "react";
import axios from 'axios';
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

function SongPage(){
    const[songs, setSongs] = useState([])

    const fetchSongs = async () => {
        try{
            const response = await axios.get('http://localhost:8081/songs');
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
        return <Container key={id}>
            <Row>
                <Col>
                    <h3>{song.songName}</h3>
                    <p>By {song.artistName}</p>
                    <p>From {new Date (`${song.year}`).getFullYear()}</p>
                </Col>
            </Row>
        </Container>
    })

    return(
        <>
            {s}
        </>
    );
}

export default SongPage;