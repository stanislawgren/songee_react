import axios from 'axios'

export const getPairDetails = async (user_id) => {
    return new Promise((resolve, reject) => {
        axios({
            method: 'GET',
            url: 'http://localhost:8080' + '/api/pair/' + user_id,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${localStorage.getItem('token')}`,
            },
        })
            .then((result) => resolve(result.data))
            .catch((error) => resolve(error.response))
    })
}

export const getPairs = async () => {
    return new Promise((resolve, reject) => {
        axios({
            method: 'GET',
            url: 'http://localhost:8080' + '/api/pair/all',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${localStorage.getItem('token')}`,
            },
        })
            .then((result) => resolve(result.data))
            .catch((error) => resolve(error.response))
    })
}
