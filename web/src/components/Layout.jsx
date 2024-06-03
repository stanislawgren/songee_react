import { Outlet } from 'react-router-dom'
import { Navbar } from './Navbar'
import { useEffect, useState } from 'react'
import { getInitialUser } from '../../services/userService'

export const Layout = () => {
    const [xuser, setxUser] = useState(null)

    const getProps = async () => {
        if (localStorage.getItem('token') == null) {
            window.location.href = '/login'
            return
        }

        let res = await getInitialUser()

        if (res.status && (res.status === 403 || res.status === 2)) {
            localStorage.clear()
            window.location.href = '/login'
            return
        }

        setxUser(res)
    }

    useEffect(() => {
        getProps()
    }, [])

    return (
        <>
            <Navbar xuser={xuser ? xuser : null} />
            <Outlet context={[xuser]} />
        </>
    )
}
