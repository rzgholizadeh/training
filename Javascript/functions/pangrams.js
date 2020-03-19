function isPangram(str) {
	for (let char of "abcdefghijklmnopqrstuvwxyz") {
		if (str.toLowerCase().indexOf(char) === -1) return false;
	}
	return true;
}

console.log(isPangram("the five Boxing wizards jump quickly"));

