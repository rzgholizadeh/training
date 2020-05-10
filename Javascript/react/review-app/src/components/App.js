import React from "react";

import keys from "../keys";
import SearchBar from "./SearchBar";
import youtube from "../apis/youtube";

class App extends React.Component {
    onTermSubmit = async (term) => {
        const result = await youtube.get("/search", {
            params: {
                q: term,
                part: "snippet",
                maxResults: 5,
                type: "video",
                key: keys.youTubeApiKey
            }
        });
        console.log(result);
    };
    render() {
        return (
            <div className="ui container">
                <SearchBar onFormSubmit={this.onTermSubmit} />
            </div>
        );
    }
}

export default App;
