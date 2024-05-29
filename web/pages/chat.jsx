import { useOutletContext } from 'react-router-dom'

export const ChatPage = () => {
    const [xuser] = useOutletContext()

    return (
        <main>
            <div className="chat-container">
                <div className="chat-container-profiles">
                    <div className="user-card">
                        <img src="https://www.w3schools.com/howto/img_avatar.png" alt="" className="user-card-image" />
                        <p>Ex. User</p>
                    </div>
                </div>
                <div className="chat-container-messages">SOON</div>
            </div>
        </main>
    )
}
