import {useEffect, useState} from "react";
import axios from "axios";
import {QuestionsCatalog} from "../model/QuestionsCatalog";


export default function useTravel() {

    const [answers, setAnswers] = useState([]);
    const [matchUser, setMatchUser] = useState([]);
    const [email, setEmail] = useState("");
    const [username, setUsername] = useState("");


    useEffect(() => {
        getAllAnswers()
    }, [])

    const getAllAnswers = () => {
        axios.get("/api/travel")
            .then(response => response.data)
            .then(data => setAnswers(data))
            .catch((error) => console.log(error))
    }


    const postAnswers = (question: QuestionsCatalog) => {
        axios.post("api/travel", question)
            .then(getAllAnswers)
            .catch(() => console.error())
    }

    const postCalcMatches = (question: QuestionsCatalog) => {
        axios.post("api/travel/match", question)
            .then(response => response.data)
            .then(data => setMatchUser(data))
            .catch(() => console.error())
    }

    const getEmail = (username: string) => {
        axios.get("api/user/" + username)
            .then(response => response.data)
            .then(data => setEmail(data))
            .catch(() => console.error())
    }



    return {answers, getAllAnswers, postAnswers, postCalcMatches, getEmail, email, matchUser, setUsername, username}

}