import React from "react";
import axios from "axios";
import keys from "../config/keys";
import SearchBar from "./SearchBar";

class App extends React.Component {
    state = { images: [] };
    onSearchSubmit = async (term) => {
        const response = await axios.get(
            "https://api.unsplash.com/search/photos",
            {
                params: {
                    query: term
                },
                headers: {
                    Authorization: `Client-ID ${keys.unsplashAccessKey}`
                }
            }
        );
        this.setState({ images: response.data.results });
    };
    render() {
        return (
            <div className="ui container" style={{ marginTop: "10px" }}>
                <SearchBar onSubmit={this.onSearchSubmit} />
                Found: {this.state.images.length}
            </div>
        );
    }
}

export default App;
