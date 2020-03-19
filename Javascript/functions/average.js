function avg(arr) {
	let sum = 0;
	for (let num of arr) {
		sum += num;
	}
	return sum / arr.length;
}

console.log(avg([10,5]));

