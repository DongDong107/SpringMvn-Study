window.addEventListener("load", function () {
    var editorDiv = this.document.querySelector("#editor");
    var toolbox = this.document.querySelector(".toolbox");
	
    toolbox.onclick = function (e) {
        e.preventDefault();
        let target = e.target;
        if (target.classList.contains("btn-bold")) {
            var selection = window.getSelection();
            console.log(selection.getRangeAt.length);
            var range = selection.getRangeAt(0);
            console.log(range);
            // range.collapse(true);
			
            // // Range.createContextualFragment() would be useful here but is
            // // non-standard and not supported in all browsers (IE9, for one)
            var el = document.createElement("div");
            el.innerHTML = "<span>hahaha</span>";
            var frag = document.createDocumentFragment(), node, lastNode;
            while ((node = el.firstChild)) {
                lastNode = frag.appendChild(node);
            }
            range.insertNode(frag);
        }
    }
});