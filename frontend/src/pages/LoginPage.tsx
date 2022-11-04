import React, {useState} from "react";
import {NavLink, useNavigate} from "react-router-dom";
import axios from "axios";
import "./LoginPage.css"

export default function LoginPage() {

    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [me, setMe] = useState("")

    const navigate = useNavigate();


    var loginSuccessful = false;
    const handleLogin = async () => {

        await axios.get("api/user/login", {auth: {username, password}})
            .then((response) => {
                setMe(response.data);
                setUsername("");
                setPassword("");
                loginSuccessful = true;
            }).catch(error => {
                console.log(error);
                alert("Sorry, Username or Password is wrong or Empty!")
                loginSuccessful = false;
            });

        if (loginSuccessful) {
            navigate("/question")
        } else {
        }
    }



    return (
        <div className={"login-main"}>

            <h1>Login Page{me}</h1>

            <h3>Login</h3>
            <input className={"input-style"} placeholder={"Username ..."} value={username} onChange={event => setUsername(event.target.value)}/>
            <input className={"input-style"} placeholder={"Password ..."} type={"password"} value={password} onChange={event => setPassword(event.target.value)}/>
            <button className={"button-style"} onClick={handleLogin}>Login</button>
            <NavLink to={"/register"}>or Sign Up?</NavLink>

        </div>

    )
}

