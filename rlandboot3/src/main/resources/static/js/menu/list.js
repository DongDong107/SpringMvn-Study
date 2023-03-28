window.addEventListener("load", function(){
	const menuList = document.querySelector(".menu-list");
	let ul = document.querySelector(".menu-category > ul");
	const form = document.querySelector(".search-header form");
	const findButton = form.querySelector(".icon-find");
	
	
	findButton.onclick = function(e){
		e.preventDefault();
		
		const queryInput = form.querySelector("input[name=q]");
		let query = queryInput.value;
		
		const request = new XMLHttpRequest();
		
		request.onload = function(){
			let menus = JSON.parse(request.responseText);
			console.log(menus);
			bind(menus);
		}
		request.open("GET",`http://localhost:8080/menus?q=${query}`,true);
		request.send();
	}
	
	ul.onclick = function(e){
		
		e.preventDefault();
		let tagName = e.target.tagName;
		if(tagName != 'LI' && tagName != 'A' )
			return;	
			
		// 클릭할 때 데이터 수집을 해야 함.
				
		let el = tagName === 'LI' ? e.target : e.target.parentElement;
		
		
		let curLi = ul.querySelector("li.menu-selected");
		
		if(el.classList.contains("menu-selected"))
			return;
			
		curLi.classList.remove("menu-selected");
		el.classList.add("menu-selected");
			
			
		let categoryId = el.dataset.cid;		
		
		load(categoryId);
	};
	
	
	function load(categoryId){
		const request = new XMLHttpRequest();
		
		request.onload = function(){
			let menus = JSON.parse(request.responseText);
			
			console.log(menuList.children);
			// 기존 목록을 다 지우고
			bind(menus);
			};
		// 브라우저에서 url을 입력하는 것과 같은 요청정보 입력
		request.open("GET",`http://localhost:8080/menus?c=${categoryId}`,true);
		request.send();
		
		
		//console.log("clicked");
		
		// li가 아니면 return;
		//if(!e.target.contains("li"))
			//return;
		// 두 가지 경우 실험해보기	 
	};
	
	function bind(menus){
		//			menuList.remove();

//			for(let i of menuList.children){
//				i.remove();
//			}
			
			while(menuList.firstElementChild)
				menuList.firstElementChild.remove();
			
			menuList.innerHTML= "<span style='color:blue'>test hello</>";
			menuList.innerHTML = "";
//			menuList.children[0].remove();			
//			menuList.removeChild(menuList.firstElementChild);
				
//		let menuSection = document.createElement("section");
//		menuSection.className = "menu";
//		
//		let form = document.createElement("form");
//		form.className="";
//				
////		menuSection.appendChild(form); // Node interface의 기능
//		menuSection.append(form); // element interface의 기능
//		
//		form.innerHTML = "<div style='color: red;'>과연 이것은 옳은 방법인가</div>"
//		menuList.append(menuSection);
		
		for(let m of menus){
			let template = 
			`<section class="menu">
	          <form class="">
	             <h1><span>${m.name}</span>/<span style="font-size:11px; vertical-align:center;" th:text="${m.categoryName}">${m.categoryName}</span></h1> 
	             <div class="menu-img-box">
	                <a href="detail" th:href="@{detail(id=${m.id})}"><img class="menu-img" src="/image/product/${m.img}" th:src="@{/image/product/{img}(img=${m.img})}"></a>
	             </div>    
	             <div class="menu-price">4500 원</div>
	             <div class="menu-option-list">
	                <span class="menu-option">
	                   <input class="menu-option-input" type="checkbox">
	                   <label>ICED</label>
	                </span>            
	                <span class="menu-option ml-2">
	                   <input class="menu-option-input" type="checkbox">
	                   <label>Large</label>
	                </span>
	             </div>
	             <div class="menu-button-list">
	                <input class="btn btn-fill btn-size-1 btn-size-1-lg" type="submit" value="담기">
	                <input class="btn btn-line btn-size-1 btn-size-1-lg ml-1" type="submit" value="주문하기">
	             </div>
	          </form>
	       </section>`;

//			menuList.innerHTML += template;	 
     		menuList.insertAdjacentHTML("beforeend",template);
     	}
		};
	
	
	
})