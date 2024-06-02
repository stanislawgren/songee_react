import { useOutletContext, useParams } from 'react-router-dom'
import { getPairs } from '../services/pairsService'
import { useEffect, useState } from 'react'
import { getRoomMessages, sendChatMessage } from '../services/messagesService'

export const ChatPage = () => {
    const [xuser] = useOutletContext()

    const { id } = useParams()
    const [pairsList, setPairsList] = useState([])
    const [message, setMessage] = useState('')
    const [messages, setMessages] = useState([])

    useEffect(() => {
        handleData()
    }, [])

    useEffect(() => {
        getMessages()
    }, [pairsList])

    const getMessages = async () => {
        let res = await getRoomMessages(id)

        if (res) {
            setMessages(res)
        }
    }

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

        if (!paramCheck) window.location.href = '/404'

        if (res.length) {
            setPairsList(res)
        }
    }

    const sendMessage = async () => {
        let res = await sendChatMessage({
            message: message,
            sender: xuser.id,
            receiver: id,
        })

        if (res.message == 'MESSAGE_SENT') {
            setMessage('')
            setMessages((messages) => [
                ...messages,
                {
                    message: message,
                    sender: xuser.id,
                    receiver: id,
                },
            ])
        }
    }

    return (
        <main>
            <div className="chat-container">
                <div className="chat-container-profiles">
                    {pairsList.map((pair, index) => {
                        return (
                            <div
                                className={id == pair.id ? 'user-card user-card-selected' : 'user-card'}
                                key={index}
                                onClick={() => {
                                    window.location.href = '/chat/' + pair.id
                                }}
                            >
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
                <div className="chat-container-messages">
                    <div className="chat-messages">
                        {messages.map((message, index) => {
                            return (
                                <div
                                    className={message.sender == xuser?.id ? 'chat-message' : 'chat-message other'}
                                    key={index}
                                >
                                    {message.message}
                                </div>
                            )
                        })}
                    </div>
                    <div className="chat-input">
                        <textarea
                            style={{
                                height: '17px',
                            }}
                            id="description"
                            maxLength="1024"
                            placeholder="Message"
                            name="description"
                            value={message}
                            onChange={(e) => {
                                setMessage(e.target.value)
                            }}
                        ></textarea>
                        <button
                            style={{
                                width: '60px',
                                height: '60px',
                            }}
                            onClick={sendMessage}
                        >
                            ►
                        </button>
                    </div>
                </div>
            </div>
        </main>
    )
}
