import axios from 'axios'

export const likeUser = async (data) => {
    return new Promise((resolve, reject) => {
        axios({
            method: 'POST',
            url: 'http://localhost:8080' + '/api/likes/like',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${localStorage.getItem('token')}`,
            },
            data: data
        })
            .then((result) => resolve(result.data))
            .catch((error) => resolve(error.response))
    })
}

export const dislikeUser = async (data) => {
    return new Promise((resolve, reject) => {
        axios({
            method: 'POST',
            url: 'http://localhost:8080' + '/api/likes/dislike',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${localStorage.getItem('token')}`,
            },
            data: data
        })
            .then((result) => resolve(result.data))
            .catch((error) => resolve(error.response))
    })
}