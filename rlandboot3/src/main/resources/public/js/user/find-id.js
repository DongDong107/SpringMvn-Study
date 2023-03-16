/**
 * 작성일: 22.08.22
 * 작성자: h
 * version: 1
 * 아이디 찾기
 */


window.addEventListener("load", function(){
	
	const sectionFindId = document.querySelector("#section-find-id");
	const submitFindId = sectionFindId.querySelector("input[type='submit']");
	let formFindId = sectionFindId.querySelector("#form-find-id");
	let email = sectionFindId.querySelector("input[name='e']");
	let userId = formFindId.querySelector("#user-id");
	
	var enterFlag = false;
	
	//엔터키 눌렀을 경우
	document.addEventListener("keydown", function(e){
		if(enterFlag) return;	//엔터키 중복 방지
		
		if(enterFlag === false && e.code == 'Enter'){
			e.preventDefault();
			submitFindId.click();
			e.target.blur();	//바인딩 없이 포커스 제거
		}
		
	});
	
	//확인버튼 클릭 시
	submitFindId.onclick = (e) => {
		e.preventDefault();
		
		//값이 없을 경우 조건 필요
		//if(email.value == null || email.value == "") return;
		
		if(enterFlag) return;	//엔터키 중복 방지
		
		if(email.value == null || email.value == ""){
			alert("이메일을 입력해주세요.");
			setTimeout(()=>{email.focus();}, 1);    //alert 창 확인 후 focus 하는 방법1
													//방법2: 콜백함수 사용하기
			return;
		} else if(checkEmail(email.value)){
			alert("이메일 형식이 잘못되었습니다.");
			setTimeout(()=>{email.focus();}, 1);
			return;
		}
		
		enterFlag = true;
		var request = new window.XMLHttpRequest();
		var url = "/user/find-id";
		var type = "POST";
		
		//객체의 현재 상태
		request.onreadystatechange = (e) => {
			
			if(request.readyState < 4)	// 4보다 작은 상태에는(요청이 다 왔을때가 아니면)
				return;
						
			//json parse
			var jsonResult = JSON.parse(request.responseText);
			
				userId.value = jsonResult.uId;
			
					//검색조건이 있을 경우
					if(userId.value != null && userId.value != ""){
				        var dlg = new Dialog();
				        
				        dlg.onsend = function(){
				        	location.href ='/user/log-in?uId=' + userId.value;
				        	enterFlag = false;	//엔터키 중복 방지       				        
				        };

				        dlg.oncancel = function(){
				            console.log("취소되었습니다.");
				            enterFlag = false;	//엔터키 중복 방지
				        };

				        dlg.confirm("확인된 아이디는<br/>" + userId.value + "입니다.");
					}else {
						var dlg = new Dialog();
						
				        dlg.onsend = function(){
				        	location.href ='/user/log-in';
				        	enterFlag = false;	//엔터키 중복 방지
				        };

				        dlg.oncancel = function(){
				            console.log("취소되었습니다.");
				            enterFlag = false;	//엔터키 중복 방지
				        };
				        
						dlg.confirm("일치하는 정보가 없습니다.");
					}
			
		};//onreadystatechange end
		
		request.open(type, url); //데이터 요청
		request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); //헤더 값 중 content-type 정의
		request.send("e=" + encodeURIComponent(email.value)); // 데이터 보내기
			
		
	}; //onclick end
	
	//encodeURIComponent(); 인코딩
	
	function checkEmail(email){
//		var reg = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
		var reg = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)$/;
		
		if(!reg.test(email)) return true; //이메일 형식이 틀렸을 경우 true 반환  -> if 조건
		else return false;
		
	}
	

});



 