window.addEventListener("load", function(){
	let ul = document.querySelector(".menu-category > ul");
	ul.onclick = function(e){
		
		e.preventDefault();
		let tagName = e.target.tagName;
		if(tagName != 'LI' && tagName != 'A' )
			return;	
			
		// 클릭할 때 데이터 수집을 해야 함.
				
		let el = tagName === 'LI' ? e.target : e.target.parentElement;
		
		let categoryId = el.data-cid;
		
		const request = new XMLHttpRequest();
		request.onload = function(){
			let menus = JSON.parse(request.responseText);
			
			console.log(menus[0]);	
		}
		// 브라우저에서 url을 입력하는 것과 같은 요청정보 입력
		request.open("GET",`http://localhost:8080/menus?c=${categoryId}`,true);
		request.send();
		
		
		//console.log("clicked");
		
		// li가 아니면 return;
		//if(!e.target.contains("li"))
			//return;
		// 두 가지 경우 실험해보기	 
	}
})