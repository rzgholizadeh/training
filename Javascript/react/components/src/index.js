import React from "react";
import ReactDOM from "react-dom";
import faker from "faker";

import CommentDetail from "./CommentDetail";
import ApprovalCard from "./ApprovalCard";

const App = () => {
    return (
        <div className="ui container comments">
            <ApprovalCard>
                <CommentDetail
                    author="Alex"
                    timeAgo="Today at 3:00PM"
                    content="Good post man!"
                    avatar={faker.image.avatar()}
                />
            </ApprovalCard>

            <ApprovalCard>
                <CommentDetail
                    author="Jennifer"
                    timeAgo="Today at 1:00PM"
                    content="Keep it up!"
                    avatar={faker.image.avatar()}
                />
            </ApprovalCard>

            <ApprovalCard>
                <CommentDetail
                    author="Carey"
                    timeAgo="Yesterday at 4:00AM"
                    content="Poor grammer"
                    avatar={faker.image.avatar()}
                />
            </ApprovalCard>
            <div></div>
        </div>
    );
};

ReactDOM.render(<App />, document.querySelector("#root"));
