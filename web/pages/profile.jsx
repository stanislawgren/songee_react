import { useOutletContext } from 'react-router-dom'

export const ProfilePage = () => {
    const [xuser] = useOutletContext()

    return (
        <main>
            <div className="container-left-profile">
                <div className="profile-wrapper">
                    <button className="edit-profile-button" id="home-page-button">
                        <span className="material-icons">edit</span>
                    </button>
                    <img id="avatar" src="https://www.w3schools.com/howto/img_avatar.png"></img>
                    <input type="file" id="avatar-input" hidden accept="image/*" />
                    <span className="profile-wrapper-credencials">
                        <span id="profile-wrapper-username">Username</span>
                        <span id="profile-wrapper-age">Age</span>
                    </span>
                </div>
                <div className="container-left-profile-inside">
                    <h2>Favourite Song</h2>
                    <input
                        type="text"
                        id="fav-song-artist"
                        className="profile-input"
                        placeholder="Favorite song artist"
                    />
                    <input
                        type="text"
                        id="fav-song-title"
                        className="profile-input"
                        placeholder="Favorite song title"
                    />
                    <h2>Favourite Artist</h2>
                    <input type="text" id="fav-artist" className="profile-input" placeholder="Favourite artist" />
                </div>
            </div>
            <div className="container-right-profile">
                <h2>User Data</h2>
                <input type="text" id="first-name" className="profile-input" placeholder="FIRST NAME" />
                <input type="text" id="last-name" className="profile-input" placeholder="LAST NAME" />
                <input type="text" id="location" className="profile-input" placeholder="LOCATION" />
                <input type="text" id="age" className="profile-input" placeholder="AGE" />
                <div>
                    <input type="radio" id="gender-choice-1" className="profile-radio-button" name="gender" value="M" />
                    <label htmlFor="gender-choice-1">Male</label>

                    <input type="radio" id="gender-choice-2" className="profile-radio-button" name="gender" value="F" />
                    <label htmlFor="gender-choice-2">Female</label>
                </div>
                <h2>Description</h2>
                <textarea id="description" maxLength="1024" placeholder="DESCRIPTION"></textarea>
                <h2>Favourite Genres</h2>
                <div id="user-genres"></div>
                <input type="text" id="genre-input" className="profile-input" placeholder="Search htmlFor genre..." />
                <ul id="genres-list"></ul>
                <button id="save-profile-data-button">SAVE DATA</button>
            </div>
        </main>
    )
}
