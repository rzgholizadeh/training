axios
	.get("https://swapi.co/api/people/")
	.then(res => {
		console.log(res.data);
	})
	.catch(err => {
		console.log("jello!");
		console.log(err);
	});


