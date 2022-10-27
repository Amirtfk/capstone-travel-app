import React, {ChangeEvent, useState} from "react";
import {QuestionsCatalog} from "../model/QuestionsCatalog";

type QuestionOverviewProps = {
    questions : QuestionsCatalog[];
    getAllAnswers :() => void;
    postAnswers : (question: QuestionsCatalog) => void;
}

export default function QuestionOverview(props: QuestionOverviewProps) {

    const [questions, setQuestion] = useState("")

    const onQuestionChange = (event: ChangeEvent<HTMLSelectElement>) => {
        setQuestion(event.target.value)
        event.preventDefault()

        console.log(event)
    }

    return (

        <form className={""}>

            <label>
                <h4>1- Which country would you like to go?</h4>
                <select
                    onChange={onQuestionChange} value={questions}
                    // onChange={(event) => setQuestion(event.target.value)}
                    defaultValue={""}
                >
                    <option value={""} disabled={true}>Select one answer</option>
                    <option value={"USA"}>USA</option>
                    <option value={"GERMANY"}>GERMANY</option>
                    <option value={"SPAIN"}>SPAIN</option>
                </select>
            </label>


            <label>
                <h4>2- Which weather do you prefer?</h4>
                <select
                       onChange={onQuestionChange} value={questions}
                    // onChange={(event) => setQuestion(event.target.value)}

                >
                    <option value={""} disabled={true}>Select one answer</option>
                    <option value={"SUNNY"}>SUNNY</option>
                    <option value={"RAINY"}>RAINY</option>
                    <option value={"SNOWY"}>SNOWY</option>
                </select>
            </label>
            <br/>



            <br/>
            <button className={""} type={"submit"} name={"Find your Buddy!"}>Find your Buddy!</button>
        </form>

    )
}