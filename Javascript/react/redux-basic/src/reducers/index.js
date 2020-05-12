// A static reducer
const songsReducer = () => {
    return [
        { title: "No Scrubs", duration: "2:00" },
        { title: "Macarena", duration: "1:23" },
        { title: "All Star", duration: "4:50" },
        { title: "Sting", duration: "5:22" }
    ];
};

// a dynamic reducer
const selectedSongReducer = (selectedSong = null, action) => {
    if (action.type === "SONG_SELECTED") {
        return action.payload;
    }
    return selectedSong;
};
