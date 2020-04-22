import React from "react";
import ReactDOM from "react-dom";
import CommentDetail from "./CommentDetail";
import faker from "faker";

const App = () => {
    return (
        <div className="ui container comments">
            <CommentDetail
                author="Alex"
                timeAgo="Today at 3:00PM"
                content="Good post man!"
                avatar={faker.image.avatar()}
            />
            <CommentDetail
                author="Jennifer"
                timeAgo="Today at 1:00PM"
                content="Keep it up!"
                avatar={faker.image.avatar()}
            />
            <CommentDetail
                author="Carey"
                timeAgo="Yesterday at 4:00AM"
                content="Poor grammer"
                avatar={faker.image.avatar()}
            />
            <div></div>
        </div>
    );
};

ReactDOM.render(<App />, document.querySelector("#root"));
