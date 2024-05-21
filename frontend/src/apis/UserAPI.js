import axios from "axios";
import TokenManager from "./TokenManager";

const UserAPI = {
    getUser: (id) => axios.get(`http://localhost:8082/users/${id}`,
    {
        headers: {Authorization: `Bearer ${TokenManager.getAccessToken()}`}
    })
    .then(response => response.data)

}

export default UserAPI;