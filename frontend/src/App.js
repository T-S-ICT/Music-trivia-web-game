import { BrowserRouter, Route, Routes } from 'react-router-dom';
import UserPage from './pages/UserPage';
import SongPage from './pages/SongPage';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route index element={<SongPage/>} ></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
