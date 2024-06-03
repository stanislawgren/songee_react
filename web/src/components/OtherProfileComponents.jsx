import { useState } from "react"
import { dislikeUser, likeUser } from "../../services/likesService"

export const OtherProfileComponent = ({ user, handleSwipe, xuser }) => {

    const [liked, setLiked] = useState(false)
    const [disliked, setDisliked] = useState(false)

    const handleLike = async (value) => {
        if (value) {
            let res = await likeUser({ user_id: xuser.id, liked_id: user.id, value: 1 })

            if (res.status == "ok") {
                setLiked(true)
                handleSwipe()
                if(res.message == "NEW_PAIR"){
                    alert("Brawo! Udało Ci się sparować")
                }
            }
        }
        else {
            let res = await dislikeUser({ user_id: xuser.id, liked_id: user.id, value: 0 })

            if (res) {
                setDisliked(true)
                handleSwipe()
            }
        }
    }

    return <div className={`main-page-profile-container 
    ${liked ? "main-page-profile-container-liked" : ""} 
    ${disliked ? "main-page-profile-container-disliked" : ""}`}>
        <div className="other-profile-wrapper">
            <img className="main-page-profiles-avatar" src={user.avatar ? user.avatar : 'https://www.w3schools.com/howto/img_avatar.png'} />
            <div className="index-wrapper-credencials">
                <span>{user.username}, {user.age}</span>
                <span>{user.location}</span>
            </div>
        </div>
        <textarea disabled="">{user.description}</textarea>
        {/* <h2>Favourite genres</h2>
        <div className="main-page-other-user-genres">
            <div className="genre-badge">hip-hop</div>
            <div className="genre-badge"> pop</div>
            <div className="genre-badge"> trap</div>
            <div className="genre-badge"> techno</div>
        </div> */}
        {user.favouriteSongArtist && <h2>Favourite Song</h2>}
        {user.favouriteSongArtist && <input
            type="text"
            id="fav-song-artist"
            classNameName="profile-input"
            value={user.favouriteSongArtist}
            disabled
        />}
        {user.favouriteSongTitle && <input
            type="text"
            id="fav-song-title"
            classNameName="profile-input"
            value={user.favouriteSongTitle}
            disabled
        />}
        {user.favouriteArtist &&
            <>
                <h2>Favourite Artist</h2>
                <input
                    type="text"
                    id="fav-artist"
                    classNameName="profile-input"
                    value={user.favouriteArtist}
                    disabled
                />
            </>}
        <div className="main-page-profile-buttons-wrapper">
            <button className="main-page-profile-dislike-button" onClick={() => {
                handleLike(false)
            }}>X</button>
            <button className="main-page-profile-like-button" onClick={() => {
                handleLike(true)
            }}>✔</button>
        </div>
    </div>
}