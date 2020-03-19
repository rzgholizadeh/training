function isValid(password, username) {
	if (password.length < 8) return false;
	if (password.indexOf(" ") !== -1) return false;
	if (password.indexOf(username) !== -1) return false;
	return true;
}

console.log(isValid("HelloKittysomeuser", "someuser"));

function otherIsValid(password, username) {
	const tooShort = password.length < 8;
	const hasSpace = password.indexOf(" ") !== -1;
	const tooSimilar = password.indexOf(username) !== -1;
	return !tooShort && !hasSpace && !tooSimilar;
}

console.log(isValid("HelloKittysomeuser", "someuser"));
