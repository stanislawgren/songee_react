import { banUser } from '../../services/adminService'

export const AdminUserListItem = (props) => {
    const handleClick = async () => {
        let res = await banUser({ user_id: props.id })

        if (res.message == 'USER_BANNED') {
            alert('User ' + props.username + ' had been banned')
        }
    }

    return (
        <div>
            <div className={'user-card user-card-selected'}>
                <img
                    src={props.avatar ? props.avatar : 'https://www.w3schools.com/howto/img_avatar.png'}
                    alt=""
                    className="user-card-image"
                />
                <p>{props.firstName ? props.firstName : props.username}</p>
                {props.status == 2 ? (
                    <span>| User already banned</span>
                ) : (
                    <button
                        style={{
                            alignSelf: 'flex-end',
                        }}
                        className="nav-button"
                        onClick={handleClick}
                    >
                        <span className="material-icons">close</span>
                    </button>
                )}
            </div>
        </div>
    )
}
