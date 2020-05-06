import axios from "axios";
import keys from "../config/keys";

export default axios.create({
    baseURL: "https://api.unsplash.com/",
    headers: {
        Authorization: `Client-ID ${keys.unsplashAccessKey}`
    }
});
