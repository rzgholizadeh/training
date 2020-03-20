function test(x = 0, y = 0) {
	return x + y;
}
console.log(test());

function anotherTest(message = "some default message") {
	console.log(message);
}

anotherTest();
// all defaults should be assigned from the last paramter to the first
// it does not work the other way
