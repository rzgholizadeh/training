const fetchNextPlanets = (url = "https://swapi.co/api/planets/") => {
	console.log(url);
	return axios.get(url);
};

const printPlanets = ({ data }) => {
	console.log(data);
	for (let planet of data.results) {
		console.log(planet.name);
	}
	// the function should return a promise to be able to chain to it
	return Promise.resolve(data.next);
};

fetchNextPlanets()
	.then(printPlanets)
	.then(fetchNextPlanets)
	.then(printPlanets)
	.catch(err => {
		console.log("Error:", err);
	});
