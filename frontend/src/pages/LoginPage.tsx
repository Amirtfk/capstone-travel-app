import React, {Dispatch, SetStateAction, useState} from "react";
import {NavLink} from "react-router-dom";
import "./LoginPage.css"

type LoginPageProps ={
    setMe : Dispatch<SetStateAction<string>>
    postUserEingeloggt : (username:string, password:string) => void
}

export default function LoginPage(props: LoginPageProps) {

    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")


    const handleLogin = async () => {
        await props.postUserEingeloggt(username, password)
        if (!username || !password === null) {
            alert("Username and Password is empty!!")
        }
    }

    return (
        <div className={"login-main"}>

            <h3 className={"font-link-first-ver"}>Sign in</h3>
            <input className={"input-style"} placeholder={"Username ..."} value={username} onChange={event => setUsername(event.target.value)}/>
            <input className={"input-style"} placeholder={"Password ..."} type={"password"} value={password} onChange={event => setPassword(event.target.value)}/>
            <button className={"button-style"} onClick={handleLogin}>Login</button>
            <NavLink className={"reglog-link"} to={"/register"}>or Sign Up?</NavLink>

        </div>

    )

}

