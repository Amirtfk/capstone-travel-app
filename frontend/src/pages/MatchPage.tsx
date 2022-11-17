import {NavLink, useNavigate} from "react-router-dom";
import ProgressBar from "@ramonak/react-progress-bar";
import "./MatchPage.css";
import {TravelUser} from "../model/TravelUser";
import React, {Dispatch, SetStateAction} from "react";
import 'animate.css';


type MatchPageProps = {
    matchUser : TravelUser[]
    postUserAusgeloggt : () => void
    me : string
    setUsername: Dispatch<SetStateAction<string>>
}


export default function MatchPage(props: MatchPageProps) {

    const navigate = useNavigate();

    async function handleLogout () {
        props.postUserAusgeloggt()
        Promise.resolve(1000).then(()=> navigate("/loqu"))

    }



    return (
        <div className={"match--main"}>
            <div className={"user-status-match"}>
                <NavLink to={"/loqu"}>{!props.me ? "zum Login":"BACK"}</NavLink>
                <button onClick={handleLogout}>Logout</button>
            </div>
            <h2 className={"font-link-first-ver animate__animated animate__fadeInDown"}>it's time to<br/> pack you'r<br/>bag!</h2>

            <div className={"progress-section"}>
                {props.matchUser.map((match) =>
                    <div>
                        <div className={"match-user--style"}>
                        <NavLink onClick={() => props.setUsername(match.name)} to={"/detail"} className={"match-user-style-match"}> {match.name} </NavLink>
                        </div>
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