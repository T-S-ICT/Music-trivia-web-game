import React, { useState } from "react";
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';

function Login(props) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');


    const handleSubmit = (event) => {
        event.preventDefault();
        props.onLogin(email, password);
    }

    return (
        <>
            <Form onSubmit={handleSubmit}>
                <Form.Group as={Row} className="mb-3" controlId="formHorizontalEmail">
                    <Form.Label column sm={2}>Email:</Form.Label>
                    <Col sm={10}>
                        <Form.Control type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} />
                    </Col>
                </Form.Group>

                <Form.Group as={Row} className="mb-3" controlId="formHorizontalPassword">
                    <Form.Label column sm={2}>Password:</Form.Label>
                    <Col sm={10}>
                        <Form.Control type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />
                    </Col>
                </Form.Group>

                <Form.Group as={Row} className="mb-3">
                    <Col sm={{ span: 10, offset: 2 }}>
                        <Button type="submit">Login</Button>
                    </Col>
                </Form.Group>
            </Form>
        </>
    )
};

export default Login;