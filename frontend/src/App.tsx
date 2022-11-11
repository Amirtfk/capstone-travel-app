import './App.css';
import {HashRouter, Route, Routes} from "react-router-dom";
import QuestionsPage from "./pages/QuestionsPage";
import MatchPage from "./pages/MatchPage";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import useTravel from "./hooks/useTravel";
import useLogin from "./hooks/useLogin";


function App() {


    const {postAnswers, postCalcMatches, matchUser} = useTravel();
    const {me, setMe, postUserEingeloggt, postUserAusgeloggt} = useLogin()


return (

    <div className="App">
        <HashRouter>
          <Routes>
            {!me ?
            <Route path={"/"} element={<LoginPage setMe={setMe} postUserEingeloggt={postUserEingeloggt} />}/>
                :
            <Route path={"/"} element={<QuestionsPage postAnswers={postAnswers} postCalcMatches={postCalcMatches} me={me} postUserAusgeloggt={postUserAusgeloggt} />}/>}
            <Route path={"/register"} element={<RegisterPage/>}/>
            <Route path={"/match"} element={<MatchPage matchUser={matchUser} postUserAusgeloggt={postUserAusgeloggt} me={me}/>}/>
          </Routes>
        </HashRouter>
    </div>

  )
}

export default App;
