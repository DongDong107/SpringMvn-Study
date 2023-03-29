/**
 * 
 */
 window.addEventListener("load", function () {
    const inputs = document.querySelectorAll("input");
    const xInput = inputs[0];
    const yInput = inputs[1];
    const resetButton = inputs[2];
    const submitButton = inputs[3];
    const resultSpan = document.querySelector("form span:last-child");
    resetButton.onclick = (e) => {
        e.preventDefault();
        xInput.value = 0;
        yInput.value = 0;
        console.log(e);
    };
    // 1way binding
    submitButton.onclick = (e) => {
        e.preventDefault();
        let x = parseInt(xInput.value);
        let y = parseInt(yInput.value);
        let result = x + y;
        resultSpan.innerText = result;
        console.log(e);
    };
    // 2way binding
//    xInput.oninput = (e) => {
//        let x = parseInt(xInput.value);
//        let y = parseInt(yInput.value);
//        let result = x + y;
//        resultSpan.innerText = result;
//    };
//    yInput.oninput = (e) => {
//        let x = parseInt(xInput.value);
//        let y = parseInt(yInput.value);
//        let result = x + y;
//        resultSpan.innerText = result;
//    };
});
