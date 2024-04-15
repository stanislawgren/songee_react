export const MainPage = () => {
  return (
    <main>
      <div className="container-left-profile">
        <div className="profile-wrapper">
          <img
            id="avatar"
            src="https://www.w3schools.com/howto/img_avatar.png"
          ></img>
          <input type="file" id="avatar-input" hidden accept="image/*" />
          <span className="index-wrapper-credencials">
            <span>
              <span id="profile-wrapper-username">Username</span>
              <span id="profile-wrapper-age"></span>
            </span>
            <span id="profile-wrapper-location">location</span>
            <button>Edit Profile</button>
          </span>
        </div>
        <div className="container-left-profile-inside">
          <h2>Favourite Song</h2>
          <input
            type="text"
            id="fav-song-artist"
            className="profile-input"
            placeholder="Favorite song artist"
            disabled
          />
          <input
            type="text"
            id="fav-song-title"
            className="profile-input"
            placeholder="Favorite song title"
            disabled
          />
          <h2>Favourite Artist</h2>
          <input
            type="text"
            id="fav-artist"
            className="profile-input"
            placeholder="Favourite artist"
            disabled
          />
          <h2>Favourite Genres</h2>
          <div id="user-genres"></div>
        </div>
      </div>
      <div className="main-page-profiles-conatiner">
        <div className="main-page-profile-container">
          <span className="span-colors">
            Unfortunately, There is no more profiles to show.
          </span>
        </div>
      </div>
    </main>
  );
};
