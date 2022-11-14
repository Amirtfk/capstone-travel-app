import QuestionOverview from "../components/QuestionOverview";
import React from "react";
import "./QuestionsPage.css";
import {QuestionsCatalog} from "../model/QuestionsCatalog";
import 'animate.css';


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
            <div className={"user-status"}>
                <p className={"user-status-login"}>Hi {props.me} !</p>
                <button onClick={handleLogout}>Logout</button>
            </div>
            <h2 className={"font-link-first-ver animate__animated animate__fadeInDown"}>Answer this questions!</h2>

            <QuestionOverview postAnswers={props.postAnswers} postCalcMatches={props.postCalcMatches} me={props.me}/>
        </div>
    )
}