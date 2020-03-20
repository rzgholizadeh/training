function sum(...nums) {
	return nums.reduce((total, currVal) => {
		return total + currVal;
	});
}

console.log(sum(1, 2, 3));
console.log(sum(2, 4, 5, 6));

// collect remaining arguments
function fullName(first, last, ...titles) {
	console.log("first: ", first);
	console.log("last", last);
	console.log("titles", titles);
}

fullName("john", "doe", "some title", "other title");
