// string
// single and double qoutes are the same!
// double qoutes can be used inside single qoutes
// sible qoutes can be used inside double qoutes
let firstName = "Akbar";
let message = 'Then he said, "come to me baby" ';
let otherMessage = "Then akbar the 'greate' came over";
let thirdMessage = "then 'asghar' said," + '"hey body!"';

// strings are indexed
let test = "test";
console.log(".   ..".length);
console.log(test[0]);
// there is no index out of bounds for the string array
console.log(test[111]);

// strings are immutable
// individual characters cannot be changed

// string methods
let someString = "aaaa";
console.log(someString.toUpperCase());
console.log(someString);
someString = "  aaa   ";
console.log(someString);
console.log(someString.trim());
// indexOf is case sensitive
someString = "012345";
console.log(someString.indexOf("34"));
console.log(someString.indexOf("9"));
// slice
console.log("Calling slice with (1,3) on '012345': " + someString.slice(1, 3));
// replace
console.log(someString.replace("01", "99"));
