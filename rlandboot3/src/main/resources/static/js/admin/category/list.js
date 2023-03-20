/**
 * 작성일: 22.09.01
 * 작성자: h
 * version: 1
 * 관리자 카테고리 목록
 */


window.addEventListener("load", function() {


	let sectionCategory = document.querySelector(".category");
	let ul = sectionCategory.querySelector("ul");
	let addBtn = sectionCategory.querySelector("#add-button");
	
	let saveBtn = "";
	let input = "";

	var addFlag = false;
	var saveFlag = false;

	addBtn.onclick = (e) => {
		e.preventDefault();

		if (addFlag) return; //이미 추가 중이면 리턴

		var html = String.raw`<li class="register-li-template">
		<form action="" id="category-form" method="POST">
	<input type="text" name="c" placeholder="카테고리명을 입력하세요." />
	</form>
	<a href="" class="btn btn-save-sm text-hidden">저장</a>
	<a href="" class="btn btn-remove-sm text-hidden">삭제</a>
</li>`;

		ul.insertAdjacentHTML("beforeend", html);

		var template = sectionCategory.querySelector(".register-li-template");
		template.animate([
			{ opacity: 0 },
			{ opacity: 1, }], 700);

		addFlag = true;
		saveFlag = true;	//저장시작
		saveBtn = sectionCategory.querySelector(".btn-save-sm");
		input = sectionCategory.querySelector("input[name='c']");
		
		//저장버튼 클릭 시
		saveBtn.addEventListener("click", function(e){
			e.preventDefault();
			
			if (input.value == null || input.value == ""){
				alert("카테고리명을 입력하세요.");
				setTimeout(()=>{input.focus();}, 1);    //alert 창 확인 후 focus 하는 방법1
				return;
			}else if(!containKOR(input.value)){
				alert("잘못된 카테고리명입니다.");
				setTimeout(()=>{input.focus();}, 1);    //alert 창 확인 후 focus 하는 방법1
				return;
			}
			
			if (saveFlag) {
				//asyncSaveCategory(input.value);
				var form = sectionCategory.querySelector("#category-form");
				form.submit();
			}
			
		}, false);

	};
	

	
function asyncSaveCategory(input){

		var request = new window.XMLHttpRequest();
		var url = "/admin/category/addList";
		var type = "POST";

		//객체의 현재 상태
		request.onreadystatechange = (e) => {

			if (request.readyState < 4)	// 4보다 작은 상태에는(요청이 다 왔을때가 아니면)
				return;

		};//onreadystatechange end

		request.open(type, url); //데이터 요청
		request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); //헤더 값 중 content-type 정의
		request.send("c=" + encodeURIComponent(input)); // 데이터 보내기

		saveFlag = false; //저장종료
};






});

