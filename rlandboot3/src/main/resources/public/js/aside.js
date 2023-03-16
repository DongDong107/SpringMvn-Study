window.addEventListener("load", function(){
	
	    /* aside-menu */
	
    let asideMenubarIcon = document.querySelector(".icon-menu-contents");
    let asideMenuBar = document.querySelector(".aside-bar");
    let btnClose = asideMenuBar.querySelector(".icon-close");
	
    // 어사이드 메뉴바 나타나게
    asideMenubarIcon.onclick = (e)=>{

        e.preventDefault();
                
        asideMenuBar.classList.add("show");

    };

    // 어사이드 메뉴바 숨기기
    asideMenuBar.onclick = (e)=>{

        if(e.target != asideMenuBar)
            return;

        asideMenuBar.classList.remove("show");

    };
    
    //닫기버튼 누를 시
    btnClose.onclick = (e)=>{
		e.preventDefault();
		
		if(!asideMenuBar.classList.contains("show")) return;

        if(e.target != btnClose)
            return;

        asideMenuBar.classList.remove("show");

    };
	

});
