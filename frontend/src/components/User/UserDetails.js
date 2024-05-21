

const UserDetails = ({ userDetails }) => {
    return (
        <div>
            <p>User Details</p>
            <ul>
                <li>Username: {userDetails.username}</li>
                <li>Email: {userDetails.email}</li>
            </ul>
        </div>
    );
}

export default UserDetails;