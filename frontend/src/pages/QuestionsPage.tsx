import {NavLink} from "react-router-dom";
import QuestionOverview from "../components/QuestionOverview";
import useTravel from "../hooks/useTravel";


export default function QuestionsPage(){

    const {answers, getAllAnswers, postAnswers} = useTravel();

    return(
        <div>
            <NavLink to={"/login"}>zur Login Page</NavLink>
            <NavLink to={"/match"}>zur Match Page</NavLink>
            <h1>Question Page</h1>
            <QuestionOverview questions={answers} getAllAnswers={getAllAnswers} postAnswers={postAnswers}/>
        </div>
    )
}