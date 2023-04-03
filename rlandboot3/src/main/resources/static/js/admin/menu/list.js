/**
 * 
 */
 
 Vue
 .createApp({
	data(){
		
		return{
			test:"hello",
			list:[
				{id:1, name:"아메리카노", price:5000},
				{id:21, name:"카페라떼", price:5700},
				{id:31, name:"카페모카", price:5700}
			],
			isShowRegForm:true,
			isShowMenu:false,
			menu:{name:"",price:0}
			
		};
	},
	methods:{
		menuSaveHandler(){
			var myHeaders = new Headers();
			myHeaders.append("Content-Type", "application/json");
			
			var raw = JSON.stringify(this.menu);
			
			var requestOptions = {
			  method: 'POST',
			  headers: myHeaders,
			  body: raw,
			  redirect: 'follow'
			};
			
			fetch("http://localhost:8080/menus?", requestOptions)
			  .then(response => response.text())
			  .then(result => {
					if(result==="ok");
					this.load();
				})
			  .catch(error => console.log('error', error));
		},
		async categoryClickHandler(e){
//			this.load(e.target.dataset.id, function(){
//				console.log("도착했구나..");
//			});
			
			this.load(2);
//			console.log("click");
//			await this.load(e.target.dataset.id);
//			console.log(" 데이터가 도착한 후에 할 일");			
			 // unshift(): 앞으로 넣는 것. , push() 뒤로, pop() 뒤부터 빼는거, 6shift() 앞에서 빼는거
			this.list.push({id:42, name:"아이스티", price:3000});
		},
		load(){
		//	fetch("/menus",(response)=>{});
			
			let promise = fetch("/menus")	
			.then(response=>{				
				return response.json();
			})
			.then(list=>{
				this.list = list;	
			})
			.catch(error=>{
				console.log("폭탄 받아라~~!!",error);
			});		
			
//			console.log("나도 끼쥐~");
//				console.log(response);
//				if(!response.ok){
//					throw new Error(response);
//				}
			
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

		},
		menuAddHandler(){
			this.isShowRegForm = !this.isShowRegForm;
			console.log("메뉴추가");
		},
		menuRemoveHandler(){
			this.isShowMenu = ! this.isShowMenu;
		}
	},
	beforeCreate(){console.log("beforeCreate")},
	created(){console.log("created")},
	beforeMount(){console.log("beforeMount")},
	mounted(){
		this.load();
		console.log("mounted")},
	beforeUpdate(){console.log("beforeUpdate")},
	updated(){console.log("updated")},
	beforeUnmount(){console.log("beforeUnmount")},
	unmounted(){console.log("unmounted")}
})	
.mount("#main-section");