import React, { useEffect, useState } from 'react';
import axios from 'axios';

export const RegisterPage = () => {

  useEffect(()=>{
    if(localStorage.getItem('token') != null){
      window.location.href = '/'
    }
  },[])

  const [login, setLogin] = useState()
  const [password, setPassword] = useState()
  const [passwordRepeat, setPasswordRepeat] = useState()
  const [mail, setMail] = useState()

  const registerSevice = async () => {
    return new Promise((resolve, reject) => {
      axios({
        method: 'POST',
        url: 'http://localhost:8080' + "/api/auth/register",
        headers: {
          'Content-Type': 'application/json'
        },
        data: {
          'username': login,
          'password': password,
          'passwordRepeat': passwordRepeat,
          'mail': mail
        }
      })
        .then((result) => resolve(result.data))
        .catch((error) => resolve(error))
    })

  }

  const handleRegister = async () => {
    let res = await registerSevice()

    console.log(res)
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
          <input type="text" id="username" placeholder="USERNAME" onChange={(e) => { setLogin(e.target.value) }} />
          <input type="password" id="password" placeholder="PASSWORD" onChange={(e) => { setPassword(e.target.value) }} />
          <input
            type="password"
            id="repeat-password"
            placeholder="REPEAT PASSWORD"
            onChange={(e) => { setPasswordRepeat(e.target.value) }}
          />
          <input type="text" id="mail" placeholder="MAIL" onChange={(e) => { setMail(e.target.value) }} />
          <button id="register-button" onClick={handleRegister}>REGISTER</button>
          <a className="a-signup" href="/login">
            Already have an account? Sign in!
          </a>
        </div>
      </div>
    </div>
  );
};
