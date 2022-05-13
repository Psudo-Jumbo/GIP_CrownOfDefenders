Vue.component('todo-item', {
	props: ['todo'],
	template: '<li><button v-on:click="SetPrevieuwC(todo)">{{ todo.classname }}</button></li>',
	methods: {
		SetPrevieuwC(todo){
			this.PrevieuwCName = todo;
		}
	}
})

var app = new Vue({
  el: '#app',
  data: {
	screenwidth: '',
	screenheight: '',
	
    P1Name: '',
	P2Name: '',
	Characters: [],
	P1CharSelected: false,
	P2CharSelected: false,
	
	PrevieuwCName1: '',
	PrevieuwCName2: '',
	
	Char1Attack1: '',
	Char1Attack2: '',
	Char1Attack3: '',
	
	Char1AttackPrevieuw: '',
	Char2AttackPrevieuw: '',
	
	Char1Image: '',
	Char2Image: '',
	
	Char1ReadyAttack: '',
	Char2ReadyAttack: '',
	
	Char2Attack1: '',
	Char2Attack2: '',
	Char2Attack3: '',
	
	Char2ReadyAttack: '',
	
	CombatState: false,
	
	P1LockedIn: '',
	P2LockedIn: '',
	
	Char1Ready: false,
	Char2Ready: false,
	
	fast: '',
	slow: '',
	
	Win: '',
	Los: '',
	
	P2win: false,
	WinImage: '',
	
	firstwent: false,
 	},
	methods: {
		SetPrevieuwC1: function(PrevC){
			this.PrevieuwCName1 = PrevC
			this.StartButton();
			document.getElementById('play1image').src = this.PrevieuwCName1.classname + ".png"
			document.getElementById('combat1image').src = this.PrevieuwCName1.classname + ".png"
			console.log(this.PrevieuwCName1.classname + ".png")
		},
		SetPrevieuwC2: function(PrevC){
			this.PrevieuwCName2 = PrevC
			this.StartButton();
			document.getElementById('play2image').src = this.PrevieuwCName2.classname + "2.png"
			document.getElementById('combat2image').src = this.PrevieuwCName2.classname + "2.png"
			console.log(this.PrevieuwCName2.classname + ".jpg")
		},
		StartButton: function(){
			if(Boolean(this.SetPrevieuwC1) && Boolean(this.SetPrevieuwC2)){
				document.getElementById('StartButton').style.display = 'block';
			}
		},
		StartCombat: function(){
			this.CombatState = true
			setTimeout(this.SetCombat, 100)
		},
		
		SetCombat: function(){
			
			if(this.PrevieuwCName1.classname == null){
				this.PrevieuwCName1 = this.Examplecharacters[0]
			}
			if(this.PrevieuwCName2.classname == null){
				this.PrevieuwCName2 = this.Examplecharacters[0]
			}
			
			document.getElementById('StartFlexbox').style.display = 'none';
			
			document.getElementById('flex-container-super-combat').style.display = "block";
			
			this.Char1Attack1 = this.PrevieuwCName1.attacks[0]
			this.Char1Attack2 = this.PrevieuwCName1.attacks[1]
			this.Char1Attack3 = this.PrevieuwCName1.attacks[2]
			
			this.Char2Attack1 = this.PrevieuwCName2.attacks[0]
			this.Char2Attack2 = this.PrevieuwCName2.attacks[1]
			this.Char2Attack3 = this.PrevieuwCName2.attacks[2]
			
		},
		
		LockIn1:function(){
			document.getElementById('actions1all').style.display = "none"
			this.Char1Ready = true
			this.P1LockedIn = this.Char1ReadyAttack
			if(this.Char1Ready==true && this.Char2Ready==true){
				this.Attackround();
			}
			
		},
		
		LockIn2:function(){
			document.getElementById('actions2all').style.display = "none"
			this.Char2Ready = true
			this.P2LockedIn = this.Char2ReadyAttack
			if(this.Char1Ready==true && this.Char2Ready==true){
				this.Attackround();
			}
			
		},
		
		Attackround:function(){
			
			console.log('Round Started')
			console.log("P1: " + this.PrevieuwCName1)
			console.log("P2: " + this.PrevieuwCName2)
			
			if(this.PrevieuwCName1.speed > this.PrevieuwCName2){

				this.UseAttack(this.PrevieuwCName1, this.PrevieuwCName2, this.LockIn1)
		
				if(this.PrevieuwCName2.hp_current >= 0){
					this.Win = this.PrevieuwCName1
					this.Los = this.PrevieuwCName2
					this.MatchOver();
				}
				else{
					
				this.UseAttack(this.PrevieuwCName2, this.PrevieuwCName1, this.LockIn2)
			
					if(this.PrevieuwCName1.hp_current >= 0){
					this.Win = this.PrevieuwCName2
					this.Los = this.PrevieuwCName1
					this.MatchOver();
					}
				}
				document.getElementById('actions1all').style.display = "block"
				
			} else if(this.PrevieuwCName1.speed < this.PrevieuwCName2){

				this.UseAttack(this.PrevieuwCName2, this.PrevieuwCName1, this.LockIn2)
		
				if(this.PrevieuwCName1.hp_current >= 0){
					this.Win = this.PrevieuwCName2
					this.Los = this.PrevieuwCName1
				}
				else{

				this.UseAttack(this.PrevieuwCName1, this.PrevieuwCName2, this.LockIn1)
			
					if(this.PrevieuwCName2.hp_current >= 0){
					this.Win = this.PrevieuwCName1
					this.Los = this.PrevieuwCName2
					this.MatchOver();
					}
				}
				document.getElementById('actions1all').style.display = "block"
		
			} else if(this.PrevieuwCName1.speed == this.PrevieuwCName2){

			this.UseAttack(this.PrevieuwCName1, this.PrevieuwCName2, this.LockIn1)
		
				if(this.PrevieuwCName2.hp_current >= 0){
					this.Win = this.PrevieuwCName1
					this.Los = this.PrevieuwCName2
					this.MatchOver();
				}
				else{
				
				this.UseAttack(this.PrevieuwCName2, this.PrevieuwCName1, this.LockIn2)
				
					if(this.PrevieuwCName1.hp_current >= 0){
					this.Win = this.PrevieuwCName2
					this.Los = this.PrevieuwCName1
					}
				}
				
			}
			document.getElementById('actions1all').style.display = "block"
			document.getElementById('actions2all').style.display = "block"
			
			console.log("P1: " + this.PrevieuwCName1)
			console.log("P2: " + this.PrevieuwCName2)
		},
		
		UseAttack:function(Attacker, Target, Attack){
			
			if(attack.AttackType().contains("Damage")) {
				var succeshits = 0;
				for(var a = 0; a<attack.hits(); a++) {
					if(attack.DamageType()== "Physical") {
				var hit = Math.random()*100;
				var damage = (int)(((attack.getPower()*((this.Strength*0.01)+1)))/2);
				if (hit.toExponential(0) <= attack.getCritrate()) {
					damage = damage*2;
				}	
				damage = (damage*(1-(target.all_Defence)+(target.Physical_Defence)));
			
				if (hit < attack.getAccuracy()-(target.Speed*0.1)){
					target.hp_current -= damage;
					succeshits += 1;
				}
			
				else {
				}
				}else if(attack.DamageType()== "Magic") {
					var hit = Math.random()*100;
					var damage = (int)(((attack.getPower()*((this.Magic*0.01)+1)))/2);
					if (hit <= attack.getCritrate()) {
						damage = damage*2;
					}
					damage = (damage*(1-(target.all_Defence)+(target.Magical_Defence)));
			
					if (hit < attack.getAccuracy()-(target.Speed*0.2)){
						target.hp_current -= damage;
						succeshits += 1;
					}
			
					else {
					}	
				}
			}
		} else if(attack.AttackType().contains("Buff")) {
			if(attack.Statboosttype().contains("Strength")) {
				this.Strength = this.Strength*((attack.Statboost()/100)+1);
			} else if (attack.Statboosttype().contains("Speed")) {
				this.Speed = this.Speed*((attack.Statboost()/100)+1);
			} else if (attack.Statboosttype().contains("Magic_D")) {
				this.Magical_Defence = this.Magical_Defence*((attack.Statboost()/100)+1);
			}else if (attack.Statboosttype().contains("Magic")) {
				this.Magic = this.Magic*((attack.Statboost()/100)+1);
			}  else if (attack.getStatboosttype().contains("Physical_D")) {
				this.Physical_Defence = this.Physical_Defence*((attack.Statboost()/100)+1);
			}
		}
			
	},
		
		MatchOver:function(){
			document.getElementById('winimage').src = this.Win.classname + ".png"
		},
		
		P1SetAttack:function(){
			document.getElementById('AttackInfoChar1').style.display = "block"
			console.log(event.target.innerHTML)
			var selectedattackvalue = event.target.innerHTML
			var player1attack = this.PrevieuwCName1.attacks
			var SelectedAttack
			for(var a = 0; a<player1attack.length; a++){
				if(player1attack[a].name == selectedattackvalue){
					console.log(player1attack[a])
					console.log(selectedattackvalue + " Selected")
					SelectedAttack = player1attack[a]
				}
			}
			this.Char1AttackPrevieuw = SelectedAttack
		},
		
		P2SetAttack:function(){
			document.getElementById('AttackInfoChar2').style.display = "block"
			console.log(event.target.innerHTML)
			var selectedattackvalue = event.target.innerHTML
			var player2attack = this.PrevieuwCName2.attacks
			var SelectedAttack
			for(var a = 0; a<player2attack.length; a++){
				if(player2attack[a].name == selectedattackvalue){
					console.log(player2attack[a])
					console.log(selectedattackvalue + " Selected")
					SelectedAttack = player2attack[a]
				}
			}
			this.Char2AttackPrevieuw = SelectedAttack
		},
		
		
		
		GetAttacks1:function(){
			console.log(this.PrevieuwCName1)
			console.log(this.PrevieuwCName1.attacks)
			var hud1buttons = document.getElementsByClassName('HudButtons1')
			for(var a = 0; a<hud1buttons.length; a++){
				hud1buttons[a].style.display = "none"
			}
			
			document.getElementById('P1AttackList').style.display = "block"
			
		},
		
		GetAttacks2:function(){
			console.log(this.PrevieuwCName2)
			console.log(this.PrevieuwCName2.attacks)
			var hud2buttons = document.getElementsByClassName('HudButtons2')
			for(var a = 0; a<hud2buttons.length; a++){
				hud2buttons[a].style.display = "none"
			}
			
			document.getElementById('P2AttackList').style.display = "block"
			
		},
		P1BackButton:function(){
			var P1Attack = document.getElementsByClassName('P1Attack')
			
			document.getElementById('P1AttackList').style.display = "none"
			
			var hud1buttons = document.getElementsByClassName('HudButtons1')
			
			for(var b = 0; b<hud1buttons.length; b++){
				hud1buttons[b].style.display = "block"
			}
		},
		
		P2BackButton:function(){
			var P2Attack = document.getElementsByClassName('P2Attack')
			
			document.getElementById('P2AttackList').style.display = "none"
			
			var hud2buttons = document.getElementsByClassName('HudButtons2')
			
			for(var b = 0; b<hud2buttons.length; b++){
				hud2buttons[b].style.display = "block"
			}
		},
		
		LockInP1:function(){
			this.P1LockedIn = this.Char1ReadyAttack
			console.log(this.P1LockedIn)
		},
		
		LockInP1:function(){}
	},
	mounted:function(){
		
		var width = window.innerWidth;
		var height = window.innerHeight;
		
		console.log("widht:" + width + " Height:" + height)
		
		this.screenwidth = width;
		this.screenheight = height;
		
		var app = document.getElementById('app');
		app.style.width = width;
		app.style.height = height;
		
		let self = this
		axios.get('http://localhost:8080/GetClasses').then(function (response) {
		    // handle success
			var Examplecharacters = []
			self.Characters = response.data
			console.log(self.Characters)
			
			console.log(document.getElementById('app').style.height)
			console.log(document.getElementById('app').style.width)
  		})
		
	}
})