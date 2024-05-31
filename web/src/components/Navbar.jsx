export const Navbar = () => {
    return (
        <nav>
            <div className="nav-adapter">
                <button className="nav-button" id="home-page-button" onClick={()=>{
                    window.location.href = "/"
                }}>
                    <span className="material-icons">home</span>
                </button>
                <a className="nav-title">SONGEE</a>
                <button className="nav-button" id="menu-button" onClick={()=>{
                    window.location.href = "/"
                }}>
                    <span className="material-icons">menu</span>
                </button>
            </div>
        </nav>
    )
}
