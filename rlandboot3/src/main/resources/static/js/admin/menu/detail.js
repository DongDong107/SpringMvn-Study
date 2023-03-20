import DeleteDlg from "./delete-dlg.js";

window.addEventListener("load", function(event) {

    var main = document.querySelector("main");
    var btnBox = main.querySelector(".btn-box");
    var nutBtn = btnBox.querySelector(".btn-default");

    btnBox.onclick = function(e) {

        if(!e.target.classList.contains("btn-remove"))
			return;

        e.preventDefault();
        var request = new window.XMLHttpRequest();
		var type = "DELETE";
		var link = location.href;
		
		var lastIndex = link.indexOf("=");
		
		var id = link.substring(lastIndex+1);
		var url = "/api/menus/" + id;

		var del = new DeleteDlg("삭제하시겠습니까?", "네", "아니요", "", "");
		del.open();

        request.onreadystatechange = function(e) {
            if(request.readyState < 4)
                return;

                console.log(request.responseText);
				location.href = "/admin/menu/list";
        };

		del.onconfirm = function() {
	        request.open(type, url);    // 데이터 삭제
	        request.send(); // 데이터 보내기
		}
		
    };

    // menu-info-edit
    nutBtn.onclick = function(e) {
        e.preventDefault();

        const nutrition = new Nutrition();

        nutrition.open();

    }

});