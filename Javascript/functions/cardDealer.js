function getRndElement(arr) {
	return arr[Math.floor(Math.random() * arr.length)];
}

function getCard() {
	const values = [
		"1",
		"2",
		"3",
		"4",
		"5",
		"6",
		"7",
		"8",
		"9",
		"10",
		"J",
		"Q",
		"K",
		"A"
	];
	const suits = ["Diamonds", "Hearts", "Clubs", "Spades"];
	return {
		suit: getRndElement(suits),
		value: getRndElement(values)
	};
}

console.log(getCard());
