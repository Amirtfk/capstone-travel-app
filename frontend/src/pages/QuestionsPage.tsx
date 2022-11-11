import {NavLink} from "react-router-dom";
import QuestionOverview from "../components/QuestionOverview";
import React from "react";
import "./QuestionsPage.css";
import {QuestionsCatalog} from "../model/QuestionsCatalog";


type QuestionspageProps = {
    postAnswers : (question: QuestionsCatalog) => void
    postCalcMatches : (question: QuestionsCatalog) => void
    postUserAusgeloggt : () => void
    me : string
}

export default function QuestionsPage(props: QuestionspageProps){

    function handleLogout () {
       props.postUserAusgeloggt()
    }

    return(
        <div className={"question-main"}>
            <p className={"user-status-login"}>Hi {props.me}</p>
            <button className={"button-style"} onClick={handleLogout}>Logout</button>

            <QuestionOverview postAnswers={props.postAnswers} postCalcMatches={props.postCalcMatches} me={props.me}/>
            <NavLink to={"/match"}>zur Match Page</NavLink>
        </div>
    )
}