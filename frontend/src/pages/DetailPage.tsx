import {useEffect} from "react";

type DetailPageProps = {
    email: string;
    username: string;
    getEmail: (username: string) => void;
}

export default function DetailPage(props: DetailPageProps) {

    useEffect(()=> {
        props.getEmail(props.username)
    },[props]);

    return (

        <div>
            <p> {props.username}{props.email} </p>
        </div>
    )

}