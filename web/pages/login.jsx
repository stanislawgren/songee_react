import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from "react-router-dom";

export const LoginPage = () => {

  const [login, setLogin] = useState()
  const [password, setPassword] = useState()

  const loginSevice = async () => {
    return new Promise((resolve, reject) => {
      axios({
        method: 'POST',
        url: 'http://localhost:8080' + "/api/auth/login",
        headers: {
          'Content-Type': 'application/json'
        },
        data: {
          'username': login,
          'password': password
        }
      })
        .then((result) => resolve(result.data))
        .catch((error) => resolve(error))
    })

  }

  const handleLogin = async () => {
    let res = await loginSevice()

    if(res.token){
      localStorage.setItem("token", res.token); 
      window.location.href = "/"
    }
  }

  return (
    <div className="auth-container">
      <div id="container-left">
        <div className="centring-container">
          <a className="container-left-title">SONGEE</a>
          <a className="container-left-subtitle">
            Connect with people. For who they are.
          </a>
        </div>
      </div>
      <div id="container-right">
        <div className="centring-container">
          <input type="text" id="username" onChange={(e) => { setLogin(e.target.value) }} placeholder="USERNAME" />
          <input type="password" id="password" onChange={(e) => { setPassword(e.target.value) }} placeholder="PASSWORD" />
          <button id="login-button" onClick={handleLogin}>LOGIN</button>
          <a className="a-signup" href="/register">
            dont have an account? Sign Up
          </a>
        </div>
      </div>
    </div>
  );
};
