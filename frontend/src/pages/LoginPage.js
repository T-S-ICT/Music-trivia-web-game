import React, { useState, useEffect } from "react";
import AuthLoginAPI from "../apis/AuthLoginAPI";
import UserAPI from "../apis/UserAPI";
import TokenManager from "../apis/TokenManager";
import Login from "../components/User/Login";
import UserDetails from "../components/User/UserDetails";

function LoginPage() {
    const [claims, setClaims] = useState(TokenManager.getClaims());
    const [userDetails, setUserDetails] = useState(null);

    const handleLogin = (email, password) => {
        AuthLoginAPI.login(email, password)
            .catch(() => alert("Login failed!"))
            .then(claims => setClaims(claims))
            .then(getUserDetails)
            .catch(error => console.error(error));
    }

    const getUserDetails = () => {
        const claims = TokenManager.getClaims();
        if (claims?.roles?.includes('PLAYER') && claims?.userId) {
            UserAPI.getUser(claims.userId)
                .then(client => setUserDetails(client))
                .catch(error => console.error(error));
        }
    }

    const handleLogout = () => {
        TokenManager.clear();
        setClaims(null);
        setUserDetails(null);
        //reload();
    }

    useEffect(() => {
        getUserDetails();
    }, [claims]);

    return (
        <>
            {claims ? (<div>
                <p>Welcome, {claims.sub}</p>
                {userDetails && <UserDetails userDetails={userDetails} />}
                <button onClick={handleLogout}>Logout</button>
                <br />
            </div>) : (<Login onLogin={handleLogin} />)}
        </>
    );
}

export default LoginPage;