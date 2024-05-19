import axios from 'axios';
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';

function CreateSong() {
    const reload=()=>window.location.reload();

    const [songName, setSongName] = useState('');
    const [artistName, setArtistName] = useState('');
    const [genre, setGenre] = useState('');
    const [year, setYear] = useState('');

    const postSong = async () => {
        try {
            const response = await axios.post('http://localhost:8081/songs',
                { songName, artistName, genre, year})
            console.log(response)
        } 
        catch (error) {
            console.log(error)
        }
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        await postSong();
        reload();
    }



    return (
        <>
            <Form onSubmit={handleSubmit}>
                <Form.Group as={Row} className="mb-3" controlId="formHorizontalSong">
                    <Form.Label column sm={2}>Song:</Form.Label>
                    <Col sm={10}>
                        <Form.Control type="text" placeholder="Song" value={songName} onChange={(e) => setSongName(e.target.value)}/>
                    </Col>
                </Form.Group>

                <Form.Group as={Row} className="mb-3" controlId="formHorizontalArtist">
                    <Form.Label column sm={2}>Artist:</Form.Label>
                    <Col sm={10}>
                        <Form.Control type="text" placeholder="Artist" value={artistName} onChange={(e) => setArtistName(e.target.value)}/>
                    </Col>
                </Form.Group>

                <Form.Group as={Row} className="mb-3" controlId="formHorizontalGenre">
                    <Form.Label column sm={2}>Genre:</Form.Label>
                    <Col sm={10}>
                        <Form.Select value={genre} onChange={(e) => setGenre(e.target.value)}>
                            <option value="" >Genre</option>
                            <option value="ROCK">Rock</option>
                            <option value="POP">Pop</option>
                            <option value="ELECTRONIC">Electronic</option>
                        </Form.Select>
                    </Col>
                </Form.Group>

                <Form.Group as={Row} className="mb-3" controlId="formHorizontalDate">
                    <Form.Label column sm={2}>Date:</Form.Label>
                    <Col sm={10}>
                        <Form.Control type="dateTime-local" value={year} onChange={(e) => setYear(e.target.value)}/>
                    </Col>
                </Form.Group>

                <Form.Group as={Row} className="mb-3">
                    <Col sm={{ span: 10, offset: 2 }}>
                        <Button type="submit">Create</Button>
                    </Col>
                </Form.Group>
            </Form>
        </>
    );
}

export default CreateSong;