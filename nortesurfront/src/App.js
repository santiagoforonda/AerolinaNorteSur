
import React from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import Login from './Login';
import SearchFlights from './SearchFlights';
import './App.css';


const App = () => {
  return (
    <div className="app-container">
      <Router>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/search-flights" element={<SearchFlights />} />
        </Routes>        
      </Router>
    </div>
  );
};

export default App;
