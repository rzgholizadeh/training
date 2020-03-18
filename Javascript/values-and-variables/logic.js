// comaparing strings is based on ASCII code of them
// (non)equality and strict (non)equality
// == is for equality of values only. no types!
console.log("\n== : ");
console.log(4 == 4);
console.log(0 == false);
console.log(0 == "0");
console.log(0 == "someCharacter");
console.log(0 == "");
console.log(null == undefined);

// === is for equality of values and types
console.log("\n=== :  ");
console.log(4 === 4);
console.log(0 === false);
console.log(0 === "0");
console.log(0 === "someCharacter");
console.log(0 === "");
console.log(null === undefined);

// usually === (!==) is always the preference!
