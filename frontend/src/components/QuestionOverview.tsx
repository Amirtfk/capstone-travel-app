import React, {ChangeEvent, FormEvent, useState} from "react";
import {QuestionsCatalog} from "../model/QuestionsCatalog";

type QuestionOverviewProps = {
    questions : QuestionsCatalog[];
    getAllAnswers :() => void;
    postAnswers : (question: QuestionsCatalog) => void;
}

export default function QuestionOverview(props: QuestionOverviewProps) {


    const [questionCountry, setQuestionCountry] = useState("")
    const [questionWeather, setQuestionWeather] = useState("")



    const emptyQuestionsCatalog:QuestionsCatalog = {
        countryPreference: "",
        weatherPreference:""
    }

    const [questionsCatalog, setQuestionsCatalog] = useState(emptyQuestionsCatalog)


    function submitButton(event: FormEvent<HTMLFormElement>) {
        event.preventDefault()
        console.log("submitButton")

        setQuestionsCatalog(oldQuestionsCatalog => (
            {
                ...oldQuestionsCatalog,
                []
            }
        ) )


        props.postAnswers(question)
    }


    return (

        <form onSubmit={(event) => submitButton(event)}>

            <label>
                <h4>1- Which country would you like to go?</h4>
                <select
                    onChange={(event) => setQuestionCountry(event.target.value)}
                    value={questionCountry}
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
                    onChange={(event) => setQuestionWeather(event.target.value)}
                    value={questionWeather}
                >
                    <option value={""} disabled={true}>Select one answer</option>
                    <option value={"SUNNY"}>SUNNY</option>
                    <option value={"RAINY"}>RAINY</option>
                    <option value={"SNOWY"}>SNOWY</option>
                </select>
            </label>
            <br/>



            <br/>
            <button type={"submit"}>Find your Buddy!</button>
        </form>

    )
}