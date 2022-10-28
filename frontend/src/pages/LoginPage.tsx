import React, {useState} from "react";
import {NavLink} from "react-router-dom";
import axios from "axios";

export default function LoginPage() {

    const [welcomeMessage, setWelcomeMessage] = useState("")

    function fetchWelcomeMessage () {
        axios.get("/api/travel")
            .then(response => {return response.data})
            .then(data => setWelcomeMessage(data))

    }

    return (
        <div>
            <NavLink to={"/question"}>zur Question Page</NavLink>
            <h1>Login Page</h1>
            <p>{welcomeMessage}</p>
            <button onClick={fetchWelcomeMessage}>Say Hello!</button>
        </div>
    )
}