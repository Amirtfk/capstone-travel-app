import "./HomePage.css"
import {Link} from "react-router-dom";

export default function HomePage() {

    return (
        <div className={"planet-section"}>
            <div className="planet"> </div>
            <h2> Let's discover<br/>the world<br/>together!</h2>
            <Link to="/loqu">
                <button className={"buddy-button--style"}>let's start!</button>
            </Link>
        </div>
    )
}
