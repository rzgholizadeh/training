// DOM manipulation
const allLis = document.querySelectorAll("li");

for (let i = 0; i < allLis.length; i++) {
	allLis[i].innerText = "Some new text";
}

for (let li of allLis) {
	li.innerHTML = "another new <b> TEXT </b>";
}

