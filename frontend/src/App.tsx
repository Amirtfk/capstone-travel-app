import './App.css';
import {HashRouter, Route, Routes} from "react-router-dom";
import QuestionsPage from "./pages/QuestionsPage";
import MatchPage from "./pages/MatchPage";


function App() {


return (

    <div className="App">

        <HashRouter>
          <Routes>
            <Route path={"/"} element={<QuestionsPage/>}/>
            <Route path={"/match"} element={<MatchPage/>}/>
          </Routes>
        </HashRouter>

    </div>

  )
}

export default App;
