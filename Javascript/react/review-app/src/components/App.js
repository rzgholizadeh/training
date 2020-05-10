import React from "react";

import keys from "../keys";
import SearchBar from "./SearchBar";
import youtube from "../apis/youtube";

class App extends React.Component {
    state = { videos: [] };
    onTermSubmit = async (term) => {
        const response = await youtube.get("/search", {
            params: {
                q: term,
                part: "snippet",
                maxResults: 5,
                type: "video",
                key: keys.youTubeApiKey
            }
        });
        console.log(response.data.items);
        this.setState({ videos: response.data.items });
    };
    render() {
        return (
            <div className="ui container">
                <SearchBar onFormSubmit={this.onTermSubmit} />
                The list: {this.state.videos.length}
            </div>
        );
    }
}

export default App;
