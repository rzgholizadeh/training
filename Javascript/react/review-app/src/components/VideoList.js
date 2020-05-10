import React from "react";

const VideoList = (props) => {
    const videos = props.videos;
    return (
        <div>
            <div>{videos.length}</div>
        </div>
    );
};

export default VideoList;
