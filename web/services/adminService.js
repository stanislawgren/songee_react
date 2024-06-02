import axios from 'axios'

export const banUser = async () => {
    return new Promise((resolve, reject) => {
        axios({
            method: 'POST',
            url: 'http://localhost:8080' + '/api/admin/ban',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${localStorage.getItem('token')}`,
            },
            data: { xd: 'xd' },
        })
            .then((result) => resolve(result.data))
            .catch((error) => resolve(error.response))
    })
}


export const getAdminUserList = async () => {
    return new Promise((resolve, reject) => {
        axios({
            method: 'GET',
            url: 'http://localhost:8080' + '/api/admin/users/list',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${localStorage.getItem('token')}`,
            },
        })
            .then((result) => resolve(result.data))
            .catch((error) => resolve(error.response))
    })
}