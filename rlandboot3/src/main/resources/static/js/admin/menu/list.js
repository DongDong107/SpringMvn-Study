/**
 * 
 */
 
 Vue
 .createApp({
	data(){
		
		return{
			test:"hello"
		};
	},
	methods:{
		async categoryClickHandler(e){
//			this.load(e.target.dataset.id, function(){
//				console.log("도착했구나..");
//			});
			
			this.load(2);
//			console.log("click");
//			await this.load(e.target.dataset.id);
//			console.log(" 데이터가 도착한 후에 할 일");			
			
		},
		load(cid){
		//	fetch("/menus",(response)=>{});
			
			let promise = fetch("/menusdfsf11")	
			.then(response=>{
				console.log("나도 끼쥐~");
				console.log(response);
				if(!response.ok){
					throw new Error(response);
				}
				return response.json();
			})
			.then(list=>{
				console.log(list);	
			})
			.catch(error=>{
				console.log("폭탄 받아라~~!!",error);
			});		
			
			
			/*
			promise
			.then((response)=>{
				let promise = response.json();
				promise.then(list=>{
					console.log(list);
				});
			});
			*/
			
//			let response = await fetch("/menus");
//			let list = response.json();
//			console.log(list);

		}
	}
})	
.mount("#main-section");