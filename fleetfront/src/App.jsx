import { BrowserRouter, Route, Routes } from "react-router-dom";
import OutStockState from "./Components/Gate/OutStockState";
import Stockstate from "./Components/Gate/Stockstate";
import PrepareStockState from "./Components/Gate/PrepareStockState"

function App() {
  return (
    <BrowserRouter>

      <Routes>

        <Route>

          <Route path="/stockstate" element={<Stockstate/>} />

          <Route path="/outStockState" element={<OutStockState/>} />

          <Route path="/prepareStockState" element={<PrepareStockState/>} />

        </Route>        

      </Routes>

    </BrowserRouter>  

  );
}

export default App;
