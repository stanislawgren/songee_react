import axios from 'axios'

export const getInitialUser = async () => {
    return new Promise((resolve, reject) => {
        axios({
            method: 'GET',
            url: 'http://localhost:8080' + '/api/user',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${localStorage.getItem('token')}`,
            },
        })
            .then((result) => resolve(result.data))
            .catch((error) => resolve(error.response))
    })
}

export const updateUserDetails = async (data) => {
    return new Promise((resolve, reject) => {
        axios({
            method: 'PUT',
            url: 'http://localhost:8080' + '/api/user/update/details',
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

