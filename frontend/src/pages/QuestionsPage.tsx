import {NavLink} from "react-router-dom";
import QuestionOverview from "../components/QuestionOverview";
import useTravel from "../hooks/useTravel";


export default function QuestionsPage(){

    const {postAnswers} = useTravel();

    return(
        <div>
            <NavLink to={"/match"}>zur Match Page</NavLink>
            <h1>Question Page</h1>
            <QuestionOverview  postAnswers={postAnswers}/>
        </div>
    )
}