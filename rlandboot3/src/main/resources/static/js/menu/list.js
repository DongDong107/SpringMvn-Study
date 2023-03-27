window.addEventListener("load", function(){
	const menuList = document.querySelector(".menu-list");
	let ul = document.querySelector(".menu-category > ul");
	ul.onclick = function(e){
		
		e.preventDefault();
		let tagName = e.target.tagName;
		if(tagName != 'LI' && tagName != 'A' )
			return;	
			
		// 클릭할 때 데이터 수집을 해야 함.
				
		let el = tagName === 'LI' ? e.target : e.target.parentElement;
		
		let categoryId = el.dataset.cid;
		
		const request = new XMLHttpRequest();
		
		request.onload = function(){
			let menus = JSON.parse(request.responseText);
			
			console.log(menuList.children);
			// 기존 목록을 다 지우고
//			menuList.remove();

			for(let i of menuList.children){
				i.remove();
			}
//			
//			while(menuList.firstElementChild)
//				menuList.firstElementChild.remove();
			
//			menuList.children[0].remove();			
//			menuList.removeChild(menuList.firstElementChild);
		};
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