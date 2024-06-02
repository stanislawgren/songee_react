export const AdminUserListItem = (props) => {
    return (
        <div>
            <div className={'user-card user-card-selected'}>
                <img
                    src={props.avatar ? props.avatar : 'https://www.w3schools.com/howto/img_avatar.png'}
                    alt=""
                    className="user-card-image"
                />
                <p>{props.firstName ? props.firstName : props.username}</p>
                <button
                    style={{
                        alignSelf: 'flex-end',
                    }}
                    className="nav-button"
                >
                    <span className="material-icons">close</span>
                </button>
            </div>
        </div>
    )
}
