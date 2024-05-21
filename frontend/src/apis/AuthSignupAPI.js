import axios from "axios";
import TokenManager from "./TokenManager";

const AuthSignupAPI = {
    signup: (username, email, password, confirmPassword) => axios.post('http://localhost:8082/users', {username, email, password, confirmPassword})
        .then(response => response.data.accessToken)
        .then(accessToken => TokenManager.setAccessToken(accessToken))
}

export default AuthSignupAPI;