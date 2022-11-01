import {NavLink} from "react-router-dom";
import React from "react";

export default function MatchPage() {

    return (
        <div>
            <NavLink to={"/question"}>zur Question Page</NavLink>
            <NavLink to={"/"}>zur Login</NavLink>
            <h1>Match Page</h1>
        </div>
    )
}