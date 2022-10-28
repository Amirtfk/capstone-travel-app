import './App.css';
import {HashRouter, Route, Routes} from "react-router-dom";
import QuestionsPage from "./pages/QuestionsPage";
import MatchPage from "./pages/MatchPage";
import LoginPage from "./pages/LoginPage";


function App() {


return (

    <div className="App">

        <HashRouter>
          <Routes>
            <Route path={"/question"} element={<QuestionsPage/>}/>
            <Route path={"/match"} element={<MatchPage/>}/>
              <Route path={"/login"} element={<LoginPage/>}/>
          </Routes>
        </HashRouter>

    </div>

  )
}

export default App;
