import './App.css';
import {HashRouter, Route, Routes} from "react-router-dom";
import QuestionsPage from "./pages/QuestionsPage";
import MatchPage from "./pages/MatchPage";
import useTravel from "./hooks/useTravel";
import QuestionOverview from "./components/QuestionOverview";

function App() {

    const {answers, getAllAnswers, postAnswers} = useTravel();

return (

    <div className="App">
        <QuestionOverview questions={answers} getAllAnswers={getAllAnswers} postAnswers={postAnswers}/>
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
