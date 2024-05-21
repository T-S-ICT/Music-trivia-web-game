import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import { useState } from 'react';
import axios from 'axios';

function DeleteSong(props) {
    const reload = () => window.location.reload();
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const deleteSong = async (id) => {
        try {
            const response = await axios.delete(`http://localhost:8081/songs/${id}`)
            console.log(response, "Deleted")
        }
        catch (err) {
            console.log(err)

        }
    }

    const handleDelete = async (id, e) => {
        e.preventDefault();

        await deleteSong(id);
        handleClose();
        reload();
    }
    return (
        <>
            <Button variant="danger" onClick={handleShow}>Delete</Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Body>
                    <p>Are you sure you want to delete this event?</p>
                    <Button variant="secondary" onClick={handleClose}>Cancel</Button>
                    <Button variant="danger" onClick={(e) => handleDelete(props.deleteId, e)}>Yes</Button>
                </Modal.Body>
            </Modal>
        </>
    );
}

export default DeleteSong;