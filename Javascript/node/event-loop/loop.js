// node myFile.js
myFile.runContents();

const pendingTimers = [];
const pendingOSTasks = [];
const pendingOperations = [];

// new timers, tasks, operations are recorded from myFile running
myFile.runContents();

function shouldContinue() {
	// ---------------------------------------------------------
	// check one: any pending setTimeout, setInterval, setImmidiate
	// ---------------------------------------------------------
	// check two: any pending os tasks (like server port listening)
	// ---------------------------------------------------------
	// check three: any pending long running operations (like fs module)
	// ---------------------------------------------------------
	return (
		pendingTimers.length || pendingOSTasks.length || pendingOperations.length
	);
}

// Entire body executes in one "tick"
while (shouldContinue()) {
	// ---------------------------------------------------------
	// 1) node looks at pendingTimers and
	// sees if any functions are ready to be called. setTimeout, setInterval
	// ---------------------------------------------------------
	// 2) node looks at pendingOSTasks and pendingOperations and
	// executes the relevant callbacks
	// ---------------------------------------------------------
	// 3) pause execution. Continue when...
	//      - a new pendingOSTask is done
	//      - a new pendingOperation is done
	//      - a timer is about to complete
	// ---------------------------------------------------------
	// 4) look at pendingTimers. Call any setImmidiate
	// ---------------------------------------------------------
	// 5) handle any "close" events
	// ---------------------------------------------------------
}

// exit back to terminal
