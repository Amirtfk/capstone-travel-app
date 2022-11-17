import React, {useEffect} from "react";
import "./DetailPage.css"
import {useNavigate} from "react-router-dom";

type DetailPageProps = {
    email: string;
    username: string;
    getEmail: (username: string) => void;
    postUserAusgeloggt : () => void
}

export default function DetailPage(props: DetailPageProps) {

    useEffect(()=> {
        props.getEmail(props.username)
    },[]);

    const navigate = useNavigate();

    async function handleLogout () {
        props.postUserAusgeloggt()
        Promise.resolve(1000).then(()=> navigate("/loqu"))

    }

    return (

        <div className={"user-profile-section"}>
            <h2 className={"animate__animated animate__fadeInDown"}>Kontakt</h2>
            <image className={"user_profile"} />
            <p className={"profile-name"}> NAME </p>
            <p className={"profile-name-show"}>{props.username}</p>
            <p className={"profile-email"}> E-MAIL </p>
            <p className={"profile-email-show"}>{props.email}</p>
            <button onClick={handleLogout}>Logout</button>
        </div>
    )

}