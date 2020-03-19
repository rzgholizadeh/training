// foreach: the first input is the element, the second is the index
const someArr = [10, 11, 12, 13, 14];
const words = ["hi", "apple", "orange"];
someArr.forEach(function(element, index) {
	console.log(`index: ${index}, element: ${element}`);
});

// map: create a new array from an existing one
const doubleArr = someArr.map(function(num) {
	return num * 2;
});
console.log(someArr);
console.log(doubleArr);

const evenNum = someArr.map(function(n) {
	return {
		value: n,
		isEven: n % 2 === 0
	};
});
console.log(evenNum);

const capWords = words.map(function(word) {
	return word
		.toUpperCase()
		.split("")
		.join(".");
});
console.log(words);
console.log(capWords);

// arrow functions: alternative to function expressions
// if there is only one input parameter, brackets are not mandatory
const someFunc = function(x) {
	return x + x;
};
const arrowFuncVersion = x => {
	return x + x;
};

// some arrow function can have implicit return value (one expressions)
const square = n => {
	return n * n;
};

const implicitVerSquare = n => n * n;

//
