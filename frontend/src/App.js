import { BrowserRouter, Route, Routes } from 'react-router-dom';
import UserPage from './pages/UserPage';
import SongPage from './pages/SongPage';
import NavBar from './components/NavBar';
import HomePage from './pages/HomePage';


function App() {
  return (
    <div>
      <NavBar></NavBar>
      <BrowserRouter>
        <Routes>
          <Route index element={<HomePage />} ></Route>
          <Route path='/Song' element={<SongPage />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
