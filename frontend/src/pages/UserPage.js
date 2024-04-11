import React, {useState, useEffect,} from 'react';
import axios from 'axios';

function UserPage(){
    const [users, setUsers] = useState ([])
  
    const fetchUsers = async () => {
        try{
            const response = await axios.get('http://localhost:8080/users');
            console.log(response.data.getAllUser)
            setUsers(response.data.getAllUser)
        }
        catch(err){
            console.log(err);
        }
    };

    useEffect(() =>{
        fetchUsers();
    },[]);

    const test = users.map((t, id) =>{
        return <div className="use" key={id}>
        <p>{t.username}</p>
        </div>
    })
    return(
        <>{test}</>
    );
}
export default UserPage;