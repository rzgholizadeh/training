function isTouching(a, b) {
	const aRect = a.getBoundingClientRect();
	const bRect = b.getBoundingClientRect();

	return !(
		aRect.top + aRect.height < bRect.top ||
		aRect.top > bRect.top + bRect.height ||
		aRect.left + aRect.width < bRect.left ||
		aRect.left > bRect.left + bRect.width
	);
}

window.addEventListener("keyup", function(e) {
	switch (e.key) {
		case "ArrowDown" || "Down":
			moveVertical(avatar, 50);
			break;
		case "ArrowUp" || "Up":
			moveVertical(avatar, -50);
			break;
		case "ArrowRight" || "Right":
			avatar.style.transform = "scale(1,1)";
			moveHorizontal(avatar, 50);
			break;
		case "ArrowLeft" || "Left":
			avatar.style.transform = "scale(-1,1)";
			moveHorizontal(avatar, -50);
			break;
		default:
			break;
	}
	if (isTouching(avatar, coin)) {
		moveCoin();
	}
});

const moveVertical = (element, amount) => {
	const currTop = extractPosition(element.style.top);
	element.style.top = `${currTop + amount}px`;
};

const moveHorizontal = (element, amount) => {
	const currLeft = extractPosition(element.style.left);
	element.style.left = `${currLeft + amount}px`;
};

const extractPosition = pos => {
	if (!pos) return 100;
	return parseInt(pos.slice(0, -2));
};

const moveCoin = () => {
	const y = Math.floor(Math.random() * window.innerHeight);
	const x = Math.floor(Math.random() * window.innerWidth);
	coin.style.top = `${y}px`;
	coin.style.left = `${x}px`;
};

const avatar = document.querySelector("#player");
const coin = document.querySelector("#coin");
moveCoin();
