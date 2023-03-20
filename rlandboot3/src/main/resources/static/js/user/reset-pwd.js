/**
 * 작성일: 22.08.24
 * 작성자: h
 * version: 1
 * 비밀번호 재설정
 */


window.addEventListener("load", function(){
	
	const sectionResetPwd = document.querySelector("#section-reset-pwd");
	const submitResetPwd = sectionResetPwd.querySelector("input[type='submit']");
//	let formResetPwd = sectionResetPwd.querySelector("#form-reset-pwd");
	let email = sectionResetPwd.querySelector("input[name='e']");

	var enterFlag = false;
	
	//엔터키 눌렀을 경우
	document.addEventListener("keydown", function(e){
		if(enterFlag) return;	//엔터키 중복 방지
		
		if(enterFlag === false && e.code == 'Enter'){
			e.preventDefault();
			submitResetPwd.click();
			e.target.blur();	//바인딩 없이 포커스 제거
		}
		
	});
	
	//확인버튼 클릭 시
	submitResetPwd.onclick = (e) => {
		e.preventDefault();
		
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
		var request = new XMLHttpRequest();
		var url = "/user/reset-pwd";
		var type = "POST";
		
		//객체의 현재 상태
		request.onreadystatechange = (e) => {
			
			if(request.readyState < 4)	// 4보다 작은 상태에는(요청이 다 왔을때가 아니면)
				return;
						
			//json parse
			var jsonResult = JSON.parse(request.responseText);
			
					//검색조건이 있을 경우
					if(jsonResult == 1){
				        var dlg = new Dialog();
				        
				        dlg.onsend = function(){
				        	location.href ='/user/log-in';
				        	enterFlag = false;	//엔터키 중복 방지       				        
				        };

				        dlg.oncancel = function(){
				            console.log("취소되었습니다.");
				            enterFlag = false;	//엔터키 중복 방지
				        };

				        dlg.confirm("이메일이 전송되었습니다.<br/>받은 메일함을 확인해보세요.");
					}else if(jsonResult == -2){
						var dlg = new Dialog();
						
				        dlg.onsend = function(){
				        	location.href ='/user/log-in';
				        	enterFlag = false;	//엔터키 중복 방지
				        };

				        dlg.oncancel = function(){
				            console.log("취소되었습니다.");
				            enterFlag = false;	//엔터키 중복 방지
				        };
				        
						dlg.confirm("동일한 이메일이 1개 이상있습니다. <br/>이메일을 확인하세요.");
						
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
		
		request.open(type, url);
		request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		request.send("e=" + encodeURIComponent(email.value));

	};
	
	//encodeURIComponent(); 인코딩
	
	function checkEmail(email){
//		var reg = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
		var reg = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)$/;
		
		if(!reg.test(email)) return true; //이메일 형식이 틀렸을 경우 true 반환  -> if 조건
		else return false;
		
	}
	

});

 