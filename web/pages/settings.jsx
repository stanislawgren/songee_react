import { useOutletContext } from "react-router-dom";

export const SettingsPage = () => {
    const [xuser] = useOutletContext()
    return <div>settings</div>
};
