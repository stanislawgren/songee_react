import { MenuList } from './MenuList'

export const Navbar = (props) => {

    return (
        <nav>
            <div className="nav-adapter">
                <button
                    className="nav-button"
                    id="home-page-button"
                    onClick={() => {
                        window.location.href = '/'
                    }}
                >
                    <span className="material-icons">home</span>
                </button>
                <a className="nav-title">SONGEE</a>
                <button
                    className="nav-button"
                    id="menu-button"
                    onClick={() => {
                        document.getElementsByClassName('custom-menu')[0].classList.toggle('menu-active')
                    }}
                >
                    <span className="material-icons">menu</span>
                </button>
                <MenuList role={props.xuser?.role} />
            </div>
        </nav>
    )
}
