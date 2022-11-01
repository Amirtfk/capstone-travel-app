import {NavLink, useNavigate} from "react-router-dom";
import QuestionOverview from "../components/QuestionOverview";
import useTravel from "../hooks/useTravel";
import React, {useState} from "react";
import axios from "axios";
import "./QuestionsPage.css"


export default function QuestionsPage(){

    const {postAnswers} = useTravel();
    const [me, setMe] = useState("")

    const navigate = useNavigate();


    var logoutSuccessful = false;
    const handleLogout = async () => {
    await axios.get("api/user/logout")
        .then((response) => {
            setMe(response.data);
            logoutSuccessful = true;
        }).catch(error => {console.log(error);
            logoutSuccessful = false;
        });

        if (logoutSuccessful) {
            navigate("/")
        } else {
        }
    }

    return(
        <div className={"question-main"}>
            <p>Hello {me}</p>
            <button className={"button-style"} onClick={handleLogout}>Logout</button>

            <h1>Question Page</h1>
            <QuestionOverview postAnswers={postAnswers}/>
            <NavLink to={"/match"}>zur Match Page</NavLink>
        </div>
    )
}