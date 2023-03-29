Vue
.createApp({
	data(){
		return{
			x:20,
			y:30,
			z:0
		};
	},
	methods:{
		calcHandler(e){
//			e.preventDefault();
			this.z = this.x + parseInt(this.y);
			console.log(z);
		},
		resetHandler(e){
//			e.preventDefault();
			console.log("reset");
		}
		
	}	
	
})
.mount("#calc");

