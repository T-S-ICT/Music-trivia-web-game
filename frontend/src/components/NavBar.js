import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
function NavBar() {
    return (
        <>
            <Navbar bg="success" data-bs-theme="dark">
                <Container>
                    <Navbar.Brand href="/">Tune Trivia</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="/Song">Song</Nav.Link>
                        <Nav.Link href="#tba">TBA</Nav.Link>
                        <Nav.Link href="#tba">TBA</Nav.Link>
                    </Nav>
                    <Nav>
                        <Nav.Link href="SignUp">Sign up</Nav.Link>
                        <Nav.Link href="Login">Login</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
        </>
    );
}

export default NavBar;