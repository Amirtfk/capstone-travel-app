import './App.css';
import {HashRouter, Route, Routes} from "react-router-dom";
import QuestionsPage from "./pages/QuestionsPage";
import MatchPage from "./pages/MatchPage";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import useTravel from "./hooks/useTravel";
import useLogin from "./hooks/useLogin";
import HomePage from "./pages/HomePage";
import DetailPage from "./pages/DetailPage";


function App() {


    const {postAnswers, postCalcMatches, matchUser, email, getEmail, username, setUsername} = useTravel();
    const {me, setMe, postUserEingeloggt, postUserAusgeloggt} = useLogin()


return (

    <div className="App">
        <HashRouter>
          <Routes>
            <Route path={"/"} element={<HomePage/>}/>
            {!me ?
            <Route path={"/loqu"} element={<LoginPage setMe={setMe} postUserEingeloggt={postUserEingeloggt} />}/>
                :
            <Route path={"/loqu"} element={<QuestionsPage postAnswers={postAnswers} postCalcMatches={postCalcMatches} me={me} postUserAusgeloggt={postUserAusgeloggt} />}/>}
            <Route path={"/register"} element={<RegisterPage/>}/>
            <Route path={"/match"} element={<MatchPage matchUser={matchUser} postUserAusgeloggt={postUserAusgeloggt} me={me} setUsername={setUsername}/>}/>
              <Route path={"/detail"} element={<DetailPage email={email} getEmail={getEmail} username={username}/>}/>
          </Routes>
        </HashRouter>
    </div>

  )
}

export default App;
