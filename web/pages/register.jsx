export const RegisterPage = () => {
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
          <input type="text" id="username" placeholder="USERNAME" />
          <input type="password" id="password" placeholder="PASSWORD" />
          <input
            type="password"
            id="repeat-password"
            placeholder="REPEAT PASSWORD"
          />
          <input type="text" id="mail" placeholder="MAIL" />
          <button id="register-button">REGISTER</button>
          <a className="a-signup" href="/login">
            Already have an account? Sign in!
          </a>
        </div>
      </div>
    </div>
  );
};
