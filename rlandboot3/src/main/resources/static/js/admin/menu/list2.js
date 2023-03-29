window.addEventListener("load", function(){
	const menuSection = document.querySelector(".menu-section");
	const btnAdd = document.querySelector(".btn-add");
	const menuRegSection = menuSection.querySelector(".menu-reg-section");
	const imgInput = document.querySelector(".img-input");
	const fileInput = document.querySelector(".file-input");
	let btnReg = document.querySelector(".btn-reg");
	
	
	menuSection.onclick = function(e){
		
		e.preventDefault();
		
		if(!e.target.classList.contains("btn-del"))
			return;
		
		let el = null;
		for(el = e.target; el.tagName!="SECTION"; el=el.parentElement);
		
		console.log(el);
		
		
		let id = el.dataset.id;
		
		fetch(`/api/menus/${id}`, {
			method:"DELETE"
		})
		.then(resp=>resp.json())
		.then(data=>{
			let result = data.resultObject;
			
			if(result == 1){
				console.log(id);
				// section을 제거
				el.remove();
			}		
			
		});
		
		
		  
	};
	
	btnReg.onclick = function(e){	
		e.preventDefault();
			
		let img = fileInput.files[0];		
		let name = menuRegSection
					.querySelector("input[name='name']")
					.value;
		let price = menuRegSection
					.querySelector("input[name='price']")
					.value;
		
		let form = new FormData();
		form.append("img", img);
		form.append("name", name);
		form.append("price", price);
		
		//fetch("/api/menus/reg", {method:"post", body:form})
		fetch("/api/menus", {method:"put", body:form})
		.then(data=>data.json())
		.then(json=>{
			let menu = json.resultObject;
						
			let template = `
					<section class="menu border-bottom border-color-1">
		                <form class="">
		                    <h1>${menu.name}</h1> 
		                    <div class="menu-img-box">
		                        <a href="${menu.id}"><img class="menu-img" src="/image/product/${menu.img}"></a>
		                    </div>
		                    <div class="menu-price">${menu.price} 원</div>
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
								<input class="btn btn-line btn-round btn-size-1 rounded-0-md" type="submit" value="수정">
		                        <input class="btn btn-fill btn-round rounded-0-md btn-size-1 ml-1 btn-del" type="submit" value="삭제">
		                    </div>
		                </form>
		            </section>		  
			`;
			
			menuRegSection.insertAdjacentHTML("afterend", template);
			
		});
		
		
	};
	
	btnAdd.onclick = function(e){
		e.preventDefault();
		
		menuRegSection.classList.remove("d-none");		
	};
	
	imgInput.onclick = function(e){
		let event = new MouseEvent("click", {
	        'view': window,
	        'bubbles': true,
	        'cancelable': true
	    });
		//console.log(fileInput);
		fileInput.dispatchEvent(event);
	}
	
	fileInput.oninput = function(e){
		let url = fileInput.files[0];
		
		let reader = new FileReader();
		reader.onload = (evt)=>{
			imgInput.src = evt.target.result;
		};
		reader.readAsDataURL(url);
	}
});







