import React, {useState} from "react";
import {NavLink} from "react-router-dom";
import axios from "axios";
import "./RegisterPage.css"


export default function RegisterPage() {

    const [newUsername, setNewUsername] = useState("")
    const [newPassword, setNewPassword] = useState("")
    const [email, setEmail] = useState("")



    function handleRegister(){
        axios.post("/api/user/register", {
            username: newUsername,
            password: newPassword,
            email: email
        })
            .then(() => setNewUsername(""))
            .then(() => setNewPassword(""))
            .then(() => setEmail(""))
    }

    return (

    <div className={"register-main"}>
        <h1>Sign Up Page</h1>


        <h3>Sign Up</h3>
        <input className={"input-style"} placeholder={"Username ..."} value={newUsername} onChange={event => setNewUsername(event.target.value)}/>
        <input className={"input-style"} placeholder={"Password ..."} type={"Password"} value={newPassword} onChange={event => setNewPassword(event.target.value)}/>
        <input className={"input-style"} placeholder={"E-mail ..."} value={email} onChange={event => setEmail(event.target.value)}/>
        <button className={"button-style"} onClick={handleRegister}>Sign Up</button>
        <NavLink to={"/"}>Login?</NavLink>

    </div>

    )
}

