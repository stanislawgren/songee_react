export const LoginPage = () => {
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
          <button id="login-button">LOGIN</button>
          <a className="a-signup" href="/register">
            dont have an account? Sign Up
          </a>
        </div>
      </div>
    </div>
  );
};
