import axios from 'axios'

export const getRoomMessages = async (user_id) => {
    return new Promise((resolve, reject) => {
        axios({
            method: 'GET',
            url: 'http://localhost:8080' + '/api/messages/' + user_id,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${localStorage.getItem('token')}`,
            },
        })
            .then((result) => resolve(result.data))
            .catch((error) => resolve(error.response))
    })
}

export const sendChatMessage = async (data) => {
    return new Promise((resolve, reject) => {
        axios({
            method: 'POST',
            url: 'http://localhost:8080/api/messages/send',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${localStorage.getItem('token')}`,
            },
            data: data,
        })
            .then((result) => resolve(result.data))
            .catch((error) => resolve(error.response))
    })
}
