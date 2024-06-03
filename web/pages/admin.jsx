import { useEffect, useState } from 'react'
import { AdminUserListItem } from '../src/components/AdminUserListItem'
import { getAdminUserList } from '../services/adminService'

export const AdminPage = () => {
    const [userList, setUserList] = useState([])

    useEffect(() => {
        getUsers()
    }, [])

    const getUsers = async () => {
        let res = await getAdminUserList()
        setUserList(res)
    }

    return (
        <main>
            <div
                style={{
                    display: 'flex',
                    flexDirection: 'column',
                    width: '100%',
                    gap: '20px',
                }}
            >
                {userList
                    ? userList.map((user, index) => {
                          return (
                              <AdminUserListItem
                                  avatar={user.avatar}
                                  key={index}
                                  firstName={user.firstName}
                                  username={user.username}
                                  id={user.id}
                                  status={user.status}
                              />
                          )
                      })
                    : null}
            </div>
        </main>
    )
}
