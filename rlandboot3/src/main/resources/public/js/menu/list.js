window.addEventListener("load", function(){
	const ul = document.querySelector(".menu-category ul");
	const menubox = document.querySelector(".menu-list");
	let currentLi = document.querySelector(".menu-category ul li.menu-selected");
		
	let controller = new AbortController();
	
	
	ul.onclick = function(e){		
		e.preventDefault();
		const el = e.target;
		
		if(menubox.classList.contains("ajax-loader")){
			if(confirm("기달려바바좀...\n\r요청을 취소하려면 확인버튼을 눌러주세요")){			
				controller.abort();
				controller = new AbortController();
			}
				
			return;
		}
				
		if(el.tagName != "LI" && el.tagName != "A")
			return;
		let li = el;
		if(el.tagName == "A")
			li = el.parentElement;
					
		li.classList.add("menu-selected");
		currentLi.classList.remove("menu-selected");
		
		currentLi = li;
		
		// 데이터를 요청  ?c=2 -> param:2
		// /api/menus/cate/2
		let queryString = `?c=${currentLi.dataset.id}`;
		if(currentLi.dataset.id == 0)
			queryString = "";		
		
		// 요청전 -> 아이콘 띄우고
		menubox.classList.add("ajax-loader");
				
		const signal = controller.signal;
		fetch(`/api/menus${queryString}`,{signal})
		.then((response)=>response.json())
		.then((list)=>{
			menubox.innerHTML = "";
		
			for(let m of list){
				let template = `
					<section class="menu hidden">
					    <form class="" action="list" method="post">
					        <h1>${m.name}</h1> 
					        <div class="menu-img-box">
					            <a href="detail.html"><img class="menu-img" src="/image/product/12.png"></a>
					        </div>
					        <div class="menu-price">${m.price} 원</div>
					        <div class="menu-option-list">
					            <span class="menu-option">
					                <input class="menu-option-input" type="checkbox" name="ice" value="true">
					                <label>ICED</label>
					            </span>            
					            <span class="menu-option ml-2">
					                <input class="menu-option-input" type="checkbox" name="large" value="true">
					                <label>Large</label>
					            </span>
					        </div>
					        <div class="menu-button-list">
					        	<input type="hidden" name="menu-id">
					            <input class="btn btn-cancel btn-cancel-lg btn-size-1 btn-size-1-lg" type="submit" name="cmd" value="담기">
					            <input class="btn btn-default btn-default-lg btn-size-1 btn-size-1-lg ml-1" type="submit" name="cmd" value="주문하기">
					        </div>
					    </form>
					</section>
				`;
				
				//menubox.innerHTML += 
				//menubox.insertAdjacentHTML("beforeend", template);
				
				//let el = new DOMParser()
				//		.parseFromString(template, "text/html")
				//		.body
				//		.firstElementChild;
				let div = document.createElement("div");
				div.innerHTML = template;
				let el = div.firstChild;				
						
				menubox.append(el);
				
					
			}
			
			setTimeout(()=>{
				let length = menubox.children.length;
				for(let i=0; i<length; i++)
					menubox.children[i].classList.remove("hidden");				
			},10);
			
			// appendChild() / append() / insertAdjacentElement() / insertAdjacentHTML()
			// 아이콘 지우기
			menubox.classList.remove("ajax-loader");
		})
		.catch(err=>{
			console.log(`fetch error:${err.message}`);
			menubox.classList.remove("ajax-loader");
		});
		
		
		
		
		
		// 화면을 갱신
	};
});