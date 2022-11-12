import {useState} from "react";
import axios from "axios";

export  default function useLogin() {

    const [me, setMe] = useState("");


    const postUserEingeloggt = (username:string, password:string) => {
        axios.get("api/user/login", {auth: {username, password}})
        .then((response) => {
            setMe(response.data);
        }).catch(error => {
            console.log(error);
        })
    }


    const postUserAusgeloggt = () => {
        axios.get("api/user/logout")
            .then(() => {
                setMe("");
            }).catch(error => {
            console.log(error);
        })
    }


        return {me, setMe, postUserEingeloggt, postUserAusgeloggt}
}