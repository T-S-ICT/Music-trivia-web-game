import React, {useState, useEffect} from "react";
import TokenManager from "../apis/TokenManager";
import SignUp from "../components/User/SignUp";
import UserDetails from "../components/User/UserDetails";
import AuthSignupAPI from "../apis/AuthSignupAPI";
import UserAPI from "../apis/UserAPI";


function SignUpPage() {
    const [claims, setClaims] = useState(TokenManager.getClaims());
    const [userDetails, setUserDetails] = useState(null);

    const handleSignup = (username, email, password, confirmPassword) => {
        AuthSignupAPI.signup(username, email, password, confirmPassword)
            .then(claims => {
                setClaims(claims);
                return getUserDetails(); // Ensure this function returns a promise
            })
            .catch(error => {
                console.error(error);
                alert("Signup failed!");
            });
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
            </div>) : (<SignUp onSignup={handleSignup}/>)}
        </>
    )
}

export default SignUpPage;