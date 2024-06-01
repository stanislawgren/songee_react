export const MenuList = () => {
    return (
        <div className="custom-menu">
            <a className="custom-menu-button" href="/chat">
                Chat
            </a>
            <a className="custom-menu-button" href="/profile">
                Profile
            </a>
            <a className="custom-menu-button" href="/settings">
                Settings
            </a>
            <a
                className="custom-menu-button"
                onClick={() => {
                    window.localStorage.removeItem('token')
                    window.location.href = '/login'
                }}
            >
                Logout
            </a>
        </div>
    )
}
