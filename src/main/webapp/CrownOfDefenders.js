
var app = new Vue({
  el: '#app',
  data: {
    P1Name: '',
	P2Name: '',
	Characters: []
	},
	mounted:function(){
		axios.get('http://localhost:8080/GetClasses').then(function (response) {
		    // handle success
			var Examplecharacters = []
		    console.log(response.data);
			Examplecharacters = response.data
			for(var a=0; a<Examplecharacters.length; a++){
				console.log(Examplecharacters[a])
				self.data.Characters.push(Examplecharacters[a])
			}
  		})
//		console.log(Characters.response)
//		for(var a=0; a<Characters.size; a++){
//			this.Characters.put(Characters.get(a))
//		}
		
	}
})