// in function calls
const numbers = [12, 3, 1224, 42, 23, 56, 2, 79];
console.log(Math.max(...numbers));

function someFunction(a, b, c, d) {
	console.log(a);
	console.log(b);
	console.log(c);
	console.log(d);
}
const colors = ["blue", "red", "orange", "green"];
const message = "WORD";
console.log(someFunction(...colors));
console.log(someFunction(...message));

// in array literals
const arr1 = ["a", "b", "c", "d"];
const arr2 = ["1", "2", "3", "4"];
const arr3 = ["!", "@", "#"];
const mix = [...arr1, ...arr3];
console.log(mix);
// a good way to make copy of an array
// brealing a string to chars
console.log([..."hello"]);

//  in object literals
const feline = {
	legs: 4,
	family: "Felidae"
};

const canine = {
	family: "Caninae",
	furry: true
};

const dog = {
	...canine,
	isPet: true,
	adorable: true
};
console.log(dog);
