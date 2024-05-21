import axios from "axios";
import TokenManager from "./TokenManager";

const AuthLoginAPI = {
    login: (email, password) => axios.post('http://localhost:8082/users/login', {email, password})
        .then(respone => respone.data.accessToken)
        .then(accessToken => TokenManager.setAccessToken(accessToken))
}

export default AuthLoginAPI;