import {NavLink, useNavigate} from "react-router-dom";
import ProgressBar from "@ramonak/react-progress-bar";
import "./MatchPage.css";
import {TravelUser} from "../model/TravelUser";
import React from "react";


type MatchPageProps = {
    matchUser : TravelUser[]
    postUserAusgeloggt : () => void
    me : string
}


export default function MatchPage(props: MatchPageProps) {

    const navigate = useNavigate();

    async function handleLogout () {
        props.postUserAusgeloggt()
        Promise.resolve(1000).then(()=> navigate("/"))

    }


    return (
        <div>
            <NavLink to={"/"}>{!props.me ? "zum Login":"zur Question Page"}</NavLink>
            <br/>
            <button className={"button-style"} onClick={handleLogout}>Logout</button>
            <h1>Match Page</h1>

            <div className={"progress-section"}>
                {props.matchUser.map((match) =>
                    <div>
                        <p> {match.name} {match.email} </p>
                        <ProgressBar
                        completed={match.perc}
                        animateOnRender
                        maxCompleted={100}
                        bgColor="#314D67"
                        height="25px"
                    />
                    </div>
                )}
            </div>
        </div>
    );
}