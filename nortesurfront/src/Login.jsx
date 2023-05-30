
import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import './Login.css';

const Login = () => {
  const navigate = useNavigate();
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleSignIn = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/auth/signin', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
      });

      const data = await response.json();
      console.log(data);

      if (data.authenticated) {
        navigate('/search-flights');
      }
    } catch (error) {
      console.error('Error en la solicitud POST:', error);
    }
  };

  const handleSignUp = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/auth/signup', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
      });

      const data = await response.json();
      console.log(data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="login-container">
      <div className="login-header">
        <h1 className="login-title">
          <span className="login-logo">🛩️</span>
          Aerolínea Norte Sur
        </h1>
      </div>
      <form className="login-form">
        <input
          className="form-control"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          className="form-control"
          placeholder="Password"
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button className="btn-signin" onClick={handleSignIn}>
          Sign In
        </button>
        <button className="btn-signup" onClick={handleSignUp}>
          Sign Up
        </button>
      </form>
      <div className="login-footer">
        © 2023 Aerolínea Norte Sur. Todos los derechos reservados.
      </div>
    </div>
  );
  
};

export default Login;