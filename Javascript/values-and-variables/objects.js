// objects are like dictionaries in python
// like arrays, object reference is usually a const

const thisObject = {
	someKey: "someValue",
	anotherkey: 21
};
console.log(thisObject);

// all keys are converted to string
const anotherObject = {
	2: "two",
	3: "three",
	"some key with space in it!": 123
};
console.log(anotherObject[2]);

// updating the object
anotherObject.someNewKey = 12345;
console.log(anotherObject);
anotherObject.someNewKey =54321;
console.log(anotherObject);

