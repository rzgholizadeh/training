let url = "https://swapi.co/api/planets/";
let invalidUrl = "https://swapi.co/api/planetass/";

/*
function getPlanets() {
	return axios.get(url);
}

getPlanets().then(res => {
	console.log(res.data);
});
*/

async function getPlanets() {
	const res = await axios.get(invalidUrl);
	console.log(res.data);
}
// first option for error handling
getPlanets().catch(err => {
	console.log(err);
});

// second option (try catch)
async function getPlanetsTwo() {
	try {
		const res = await axios.get(invalidUrl);
		console.log(res.data);
	} catch (e) {
		console.log("Error: ", e);
	}
}
getPlanetsTwo();
