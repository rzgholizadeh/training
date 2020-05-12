import React from "react";
import { connect } from "react-redux";

class SongList extends React.Component {
    render() {
        return (
            <div>
                <div>SongList</div>
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    console.log(state);
    return state;
};

export default connect(mapStateToProps)(SongList);
