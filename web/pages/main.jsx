import { useEffect, useState } from 'react'
import { useOutletContext } from 'react-router-dom'
import { getUserList } from '../services/userService'
import { OtherProfileComponent } from '../src/components/OtherProfileComponents'

export const MainPage = () => {
    const [xuser] = useOutletContext()
    const [userList, setUserList] = useState([])

    useEffect(() => {
        getUsers()
    }, [])

    const getUsers = async () => {
        let res = await getUserList()

        setUserList(res)
    }

    const handleSwipe = (id) => {
        setTimeout(() => {
            const newList = userList.filter((l) => l.id !== id)
            setUserList(newList)
        }, 300)

    }

    return (
        <main>
            <div className="container-left-profile">
                <div className="profile-wrapper">
                    <img id="avatar" src="https://www.w3schools.com/howto/img_avatar.png"></img>
                    <input type="file" id="avatar-input" hidden accept="image/*" />
                    <span className="index-wrapper-credencials">
                        <span>
                            <span id="profile-wrapper-username">{xuser?.username}</span>
                            {xuser?.age ? <span id="profile-wrapper-age">{", " + xuser.age}</span> : null}
                        </span>
                        <span id="profile-wrapper-location">{xuser?.location}</span>
                        <button
                            onClick={() => {
                                window.location.href = '/profile'
                            }}
                        >
                            Edit Profile
                        </button>
                    </span>
                </div>
                <div className="container-left-profile-inside">
                    <h2>Favourite Song</h2>
                    <input
                        type="text"
                        id="fav-song-artist"
                        className="profile-input"
                        placeholder="Not set"
                        value={xuser?.favouriteSongArtist ? xuser?.favouriteSongArtist : ""}
                        disabled
                    />
                    <input
                        type="text"
                        id="fav-song-title"
                        className="profile-input"
                        placeholder="Not set"
                        value={xuser?.favouriteSongTitle ? xuser?.favouriteSongTitle : ""}
                        disabled
                    />
                    <h2>Favourite Artist</h2>
                    <input
                        type="text"
                        id="fav-artist"
                        className="profile-input"
                        placeholder="Not set"
                        value={xuser?.favouriteArtist ? xuser?.favouriteArtist : ""}
                        disabled
                    />
                    {/* <h2>Favourite Genres</h2>
                    <div id="user-genres"></div> */}
                </div>
            </div>
            <div className="main-page-profiles-conatiner">

                {userList.length ? userList.map((user, index) => {
                    if (user.id != xuser.id)
                        return <OtherProfileComponent user={user} key={index} handleSwipe={() => handleSwipe(user.id)} xuser={xuser} />
                    else userList.splice(index, 1)
                }) : <div className="main-page-profile-container">
                    <span className="span-colors">Unfortunately, There is no more profiles to show.</span>
                </div>}
            </div>
        </main>
    )
}