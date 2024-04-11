import { useState } from "react";

function SongPage(){
    const[songs, setSongs] = useState([])

    const fetchSongs = async () => {
        try{
            const response = await axios.get('http://localhost:8080/songs');
            console.log(response.data)
            setUsers(response.data)
        }
        catch(err){
            console.log(err)
        }
    }
    return(
        <></>
    );
}

export default SongPage;