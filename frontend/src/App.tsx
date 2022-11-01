import './App.css';
import {HashRouter, Route, Routes} from "react-router-dom";
import QuestionsPage from "./pages/QuestionsPage";
import MatchPage from "./pages/MatchPage";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";


function App() {


return (

    <div className="App">
        <HashRouter>
          <Routes>
            <Route path={"/"} element={<LoginPage/>}/>
            <Route path={"/register"} element={<RegisterPage/>}/>
            <Route path={"/question"} element={<QuestionsPage/>}/>
            <Route path={"/match"} element={<MatchPage/>}/>
          </Routes>
        </HashRouter>

    </div>

  )
}

export default App;
