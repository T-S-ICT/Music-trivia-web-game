import { BrowserRouter, Route, Routes } from 'react-router-dom';
import SongPage from './pages/SongPage';
import NavBar from './components/NavBar';
import HomePage from './pages/HomePage';
import SignUpPage from './pages/SignUpPage';
import LoginPage from './pages/LoginPage';


function App() {
  return (
    <div>
      <NavBar></NavBar>
      <BrowserRouter>
        <Routes>
          <Route index element={<HomePage />} ></Route>
          <Route path='/Song' element={<SongPage />}></Route>
          <Route path='/SignUp' element={<SignUpPage />}></Route>
          <Route path='/Login' element={<LoginPage />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
