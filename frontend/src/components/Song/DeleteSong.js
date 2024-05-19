import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import { useState } from 'react';
import axios from 'axios';

function DeleteSong(){
    const reload=()=>window.location.reload();
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const deleteSong = async(id) =>{
        try{
            const response = await axios.delete(`http://localhost:8081/songs/${id}`)
            console.log(response, "Deleted")
        }
        catch(err){
            console.log(err)

        }
    }

    const handleDelete = async (id, e) => {
        e.preventDefault();
        /*axios.delete(`http://localhost:8081/songs/${id}`)
        .then(res => console.log("Deleted", res))
        .then(err => console.log(err))*/
        
        await deleteSong(id);
        handleClose();
        reload();
    }
    return(
        <>

        </>
    );
}

export default DeleteSong;