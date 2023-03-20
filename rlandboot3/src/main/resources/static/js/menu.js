window.addEventListener("load", function(){
	
	var morePageViewButton = document.querySelector("a.btn-next");
	var location = document.querySelector("a.btn-next").offsetTop;
	console.log(morePageViewButton);
	
	morePageViewButton.onclick = function(e){
		console.log(location);
		scrollTo({left:0, top:location});
	};
	

});

 