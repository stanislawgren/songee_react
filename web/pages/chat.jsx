import { useOutletContext, useParams } from 'react-router-dom'
import { getPairs } from '../services/pairsService'
import { useEffect, useState } from 'react'

export const ChatPage = () => {
    const [xuser] = useOutletContext()

    const { id } = useParams()

    const [pairsList, setPairsList] = useState([])

    useEffect(() => {
        handleData()
    }, [])

    const handleData = async () => {
        let res = await getPairs()

        let paramCheck = false

        if (!id) {
            window.location.href = '/chat/' + res[0].id
            return
        } else {
            res.forEach((pair) => {
                if (id == pair.id) paramCheck = true
            })
        }

        if (!paramCheck) window.location.href = '/notexistingroute'

        if (res.length) {
            setPairsList(res)
        }
    }

    return (
        <main>
            <div className="chat-container">
                <div className="chat-container-profiles">
                    {pairsList.map((pair, index) => {
                        return (
                            <div className={id == pair.id ? 'user-card user-card-selected' : 'user-card'} key={index}>
                                <img
                                    src={pair.avatar ? pair.avatar : 'https://www.w3schools.com/howto/img_avatar.png'}
                                    alt=""
                                    className="user-card-image"
                                />
                                <p>{pair.firstName ? pair.firstName : pair.username}</p>
                            </div>
                        )
                    })}
                </div>
                <div className="chat-container-messages">SOON</div>
            </div>
        </main>
    )
}
