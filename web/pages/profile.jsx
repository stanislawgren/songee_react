import { useEffect, useState, useRef } from 'react'
import { useOutletContext } from 'react-router-dom'
import { updateUserDetails } from '../services/userService'
import axios from 'axios'

export const ProfilePage = () => {
    const [xuser] = useOutletContext()

    const [formData, setFormData] = useState({
        age: 0,
        favouriteSongArtist: '',
        favouriteSongTitle: '',
        favouriteArtist: '',
        firstName: '',
        lastName: '',
        location: '',
        gender: '',
        description: '',
        genreInput: '',
        genresList: [],
    })

    const fileInputRef = useRef(null)

    const handleButtonClick = () => {
        fileInputRef.current.click()
    }

    const handleFileChange = (event) => {
        const file = event.target.files[0]
        if (file) {
            const formData = new FormData()
            formData.append('file', file)

            axios
                .post('http://localhost:8080/api/file/avatar', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data',
                        Authorization: `Bearer ${localStorage.getItem('token')}`,
                    },
                })
                .then((response) => {
                    console.log('File uploaded successfully', response.data)
                })
                .catch((error) => {
                    console.error('Error uploading file', error)
                })
        }
    }

    const handleChange = (e) => {
        let { name, value } = e.target

        if (name === 'age' && value) value = parseInt(value)

        setFormData((prevState) => ({
            ...prevState,
            [name]: value,
        }))
    }

    const handleGenreAdd = () => {
        setFormData((prevState) => ({
            ...prevState,
            genresList: [...prevState.genresList, prevState.genreInput],
            genreInput: '',
        }))
    }

    useEffect(() => {
        setFormData((form) => ({
            ...form,
            ...xuser,
        }))
    }, [xuser])

    const handleUpdate = async () => {
        let res = await updateUserDetails(formData)

        console.log(res)
    }

    const getValue = (value) => (value === null ? '' : value)

    return (
        <main>
            <div className="container-left-profile">
                <div className="profile-wrapper">
                    <button className="edit-profile-button" id="home-page-button">
                        <span className="material-icons" onClick={handleButtonClick}>
                            edit
                        </span>
                    </button>
                    <img
                        id="avatar"
                        src={
                            xuser?.avatar
                                ? './../../api/' + xuser.avatar
                                : 'https://www.w3schools.com/howto/img_avatar.png'
                        }
                    ></img>
                    <input
                        type="file"
                        id="avatar-input"
                        hidden
                        accept="image/*"
                        onChange={handleFileChange}
                        ref={fileInputRef}
                    />
                    <span className="profile-wrapper-credencials">
                        <span id="profile-wrapper-username">{xuser?.username}</span>

                        <span id="profile-wrapper-age">{formData.age ? ', ' + formData.age : ''}</span>
                    </span>
                </div>
                <div className="container-left-profile-inside">
                    <h2>Favourite Song</h2>
                    <input
                        type="text"
                        id="fav-song-artist"
                        className="profile-input"
                        placeholder="Favorite song artist"
                        name="favouriteSongArtist"
                        value={getValue(formData.favouriteSongArtist)}
                        onChange={handleChange}
                    />
                    <input
                        type="text"
                        id="fav-song-title"
                        className="profile-input"
                        placeholder="Favorite song title"
                        name="favouriteSongTitle"
                        value={getValue(formData.favouriteSongTitle)}
                        onChange={handleChange}
                    />
                    <h2>Favourite Artist</h2>
                    <input
                        type="text"
                        id="fav-artist"
                        className="profile-input"
                        placeholder="Favourite artist"
                        name="favouriteArtist"
                        value={getValue(formData.favouriteArtist)}
                        onChange={handleChange}
                    />
                </div>
            </div>
            <div className="container-right-profile">
                <h2>User Data</h2>
                <input
                    type="text"
                    id="first-name"
                    className="profile-input"
                    placeholder="FIRST NAME"
                    name="firstName"
                    value={getValue(formData.firstName)}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    id="last-name"
                    className="profile-input"
                    placeholder="LAST NAME"
                    name="lastName"
                    value={getValue(formData.lastName)}
                    onChange={handleChange}
                />
                <input
                    type="text"
                    id="location"
                    className="profile-input"
                    placeholder="LOCATION"
                    name="location"
                    value={getValue(formData.location)}
                    onChange={handleChange}
                />
                <input
                    type="number"
                    id="age"
                    className="profile-input"
                    placeholder="AGE"
                    name="age"
                    value={getValue(formData.age)}
                    onChange={handleChange}
                />
                <div>
                    <input
                        type="radio"
                        id="gender-choice-1"
                        className="profile-radio-button"
                        name="gender"
                        value="M"
                        checked={formData.gender === 'M'}
                        onChange={handleChange}
                    />
                    <label htmlFor="gender-choice-1">Male</label>
                    <input
                        type="radio"
                        id="gender-choice-2"
                        className="profile-radio-button"
                        name="gender"
                        value="F"
                        checked={formData.gender === 'F'}
                        onChange={handleChange}
                    />
                    <label htmlFor="gender-choice-2">Female</label>
                </div>
                <h2>Description</h2>
                <textarea
                    id="description"
                    maxLength="1024"
                    placeholder="DESCRIPTION"
                    name="description"
                    value={getValue(formData.description)}
                    onChange={handleChange}
                ></textarea>
                <h2>Favourite Genres</h2>
                <div id="user-genres">
                    {formData.genresList.map((genre, index) => (
                        <span key={index}>{genre}</span>
                    ))}
                </div>
                <input
                    type="text"
                    id="genre-input"
                    className="profile-input"
                    placeholder="Search for genre..."
                    name="genreInput"
                    value={getValue(formData.genreInput)}
                    onChange={handleChange}
                />
                <button onClick={handleGenreAdd}>Add Genre</button>
                <button id="save-profile-data-button" onClick={handleUpdate}>
                    SAVE DATA
                </button>
            </div>
        </main>
    )
}
