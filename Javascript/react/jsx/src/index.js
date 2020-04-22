// import the react and react-dom libraries
import React from "react";
import ReactDOM from "react-dom";

function getButtonText() {
    return "submit";
}

// create a react component (function component)
const App = () => {
    return (
        <div>
            <label className="label" htmlFor="name">
                Enter Name:
            </label>
            <input id="name" type="text" />
            <button style={{ backgroundColor: "blue", color: "white" }}>
                {getButtonText()}
            </button>
        </div>
    );
};

// take the component and show it on the screen
ReactDOM.render(<App />, document.querySelector("#root"));
