import React from 'react'
import ReactDOM from 'react-dom/client'
import './styles/index.scss'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { LoginPage } from '../pages/login'
import { RegisterPage } from '../pages/register'
import { Layout } from './components/Layout'
import { MainPage } from '../pages/main'
import { SettingsPage } from '../pages/settings'
import { ChatPage } from '../pages/chat'
import { Page404 } from '../pages/404'
import { ProfilePage } from '../pages/profile'

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <BrowserRouter>
            <Routes>
                <Route path="/login" element={<LoginPage />} />
                <Route path="/register" element={<RegisterPage />} />
                <Route path="/" element={<Layout />}>
                    <Route path="" element={<MainPage />}></Route>
                    <Route path="settings" element={<SettingsPage />}></Route>
                    <Route path="chat" element={<ChatPage />}></Route>
                    <Route path="chat/:id" element={<ChatPage />}></Route>
                    <Route path="profile" element={<ProfilePage />}></Route>
                </Route>
                <Route path="*" element={<Page404 />} />
            </Routes>
        </BrowserRouter>
    </React.StrictMode>
)
