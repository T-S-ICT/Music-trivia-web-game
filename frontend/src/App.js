import React, {useState, useEffect,} from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [users, setUsers] = useState ([])
  
  const fetchUser = async () => {
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
    fetchUser();
  },[]);

  const test = users.map((t, id) =>{
    return <div className="use" key={id}>
      <p>{t.username}</p>
    </div>
  })

  return (
    <div>
      {test}
    </div>
  );
}

export default App;
