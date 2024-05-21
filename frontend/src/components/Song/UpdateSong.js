import axios from 'axios';
import { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';

function UpdateSong(props) {
    const reload = () => window.location.reload();
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const [song, setSong] = useState({
        songName: "",
        artistName: "",
        genre: "",
        year: ""
    });

    const { songName, artistName, genre, year } = song;

    const getSong = async () => {
        try {
            const response = await axios.get(`http://localhost:8081/songs/${props.editId}`)
            console.log(response.data)
            setSong(response.data)

            //Set the date to year
            const datetime = new Date(response.data.year);
            const extractedYear = datetime.getFullYear();
            console.log(extractedYear)

            const yearString = response.data.year; // Example: "2000-01-01T01:01:00"
            const yearDate = new Date(yearString);
            setSong(prevSong => ({ ...prevSong, year: yearDate }));
        } catch (err) {
            console.log(err)
        }
    }

    const editSong = async () => {
        try {
            const response = await axios.put(`http://localhost:8081/songs/${props.editId}`, song)
            console.log(response)
        } catch (err) {
            console.log(err)
        }
        reload();
    }

    const editHandle = (e) => {
        e.preventDefault();
        editSong();
    }

    const handleInput = (e) => {
        const { name, value } = e.target;

        if (name === 'year') {
            // Check if the input is a valid 4-digit year
            if (!isNaN(value) && value.length === 4) {
                // Create a new Date object with the year
                const date = new Date(Date.UTC(value, 0, 1)); // Month is 0-based
                setSong(prevSong => ({ ...prevSong, year: date }));
                console.log(date);
            } else {
                setSong(prevSong => ({ ...prevSong, year: value }));
            }
        } else {
            setSong(prevSong => ({ ...prevSong, [name]: value }));
        }
    };

    useEffect(() => {
        getSong();
    }, [])

    return (
        <>
            <Button variant="light" onClick={handleShow}>Edit</Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton onClick={handleClose}>
                    <Modal.Title>Edit Song</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={editHandle}>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Song name</Form.Label>
                            <Form.Control type="text" name='songName' value={songName} onChange={handleInput} placeholder="Song name" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                            <Form.Label>Artist name</Form.Label>
                            <Form.Control type="text" name='artistName' value={artistName} onChange={handleInput} placeholder="Artist name" autoFocus />
                        </Form.Group>
                        <Form.Group as={Row} className="mb-3" controlId="exampleForm.ControlInput3">
                            <Form.Label column sm={2}>Genre:</Form.Label>
                            <Col sm={10}>
                                <Form.Select name='genre' value={genre} onChange={handleInput}>
                                    <option value="" >Genre</option>
                                    <option value="ROCK">Rock</option>
                                    <option value="POP">Pop</option>
                                    <option value="ELECTRONIC">Electronic</option>
                                </Form.Select>
                            </Col>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput4">
                            <Form.Label>Year</Form.Label>
                            <Form.Control type="number" name='year' min="1900" max="3000" placeholder="Year" value={year instanceof Date ? year.getFullYear() : year} onChange={handleInput} />
                        </Form.Group>
                        <Button variant="secondary" onClick={handleClose} id='buttonClear'>Cancel</Button>
                        <Button variant="success" onClick={handleClose} type='submit'>Save Changes</Button>
                    </Form>
                </Modal.Body>
            </Modal>
        </>
    )
}

export default UpdateSong;