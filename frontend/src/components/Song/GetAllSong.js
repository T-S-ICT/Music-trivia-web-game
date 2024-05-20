import { useState, useEffect } from "react";
import axios from 'axios';
import Card from 'react-bootstrap/Card';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import "../../css/Spacing.css";
import DeleteSong from "./DeleteSong";

function GetAllSong() {
    const [songs, setSongs] = useState([])

    const fetchSongs = async () => {
        try {
            const response = await axios.get('http://localhost:8081/songs');
            console.log(response.data.getAllSong)
            setSongs(response.data.getAllSong)
        }
        catch (err) {
            console.log(err)
        }

        //<Button variant="danger">Delete</Button>
    }

    useEffect(() => {
        fetchSongs();
    }, []);

    const s = songs.map((song, id) => {
        return <Col key={id}>
            <Card style={{ width: '18rem' }} bg="success" text="white" key={id}>
                <Card.Body>
                    <Card.Title>{song.songName}</Card.Title>
                    <Card.Subtitle>By {song.artistName}</Card.Subtitle>
                    <p>From {new Date(`${song.year}`).getFullYear()}</p>
                    <p>Genre: {song.genre}</p>
                    <Button variant="light">Update</Button>
                    <DeleteSong deleteId={song.id} />
                </Card.Body>
            </Card>
        </Col>
    })
    return (
        <Row xs={1} md={4} className="g-4">
            {s}
        </Row>
    );
}

export default GetAllSong;