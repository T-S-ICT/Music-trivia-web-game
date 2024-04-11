import { BrowserRouter, Route, Routes } from 'react-router-dom';
import UserPage from './pages/UserPage';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route index element={<UserPage/>} ></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
