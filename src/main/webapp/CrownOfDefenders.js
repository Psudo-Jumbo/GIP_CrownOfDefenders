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
	
	Char1ReadyAttack: false,
	Char2ReadyAttack: false,
	
	Char2Attack1: '',
	Char2Attack2: '',
	Char2Attack3: '',
	
	CombatState: false,
	
	P1hpcurrent: '',
	P2hpcurrent: '',
	
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
		delay:function(time) {
  		return new Promise(resolve => setTimeout(resolve, time));
		},
		
		Entergame: function(){
			var sound = document.getElementById('introswordsound')
			
			sound.play();
			
			this.delay(500)
			
			document.getElementById('startflexcontain').style.display = "none"
			document.getElementById('StartFlexbox').style.display = "flex"
		},
		
		showinfo1: function(){
			
		},
		showinfo2: function(){
			
		},
		
		SetPrevieuwC1: function(PrevC){
			var selectsound = document.getElementById('selectsound')
			selectsound.play();
			this.PrevieuwCName1 = PrevC
			this.StartButton();
			document.getElementById('play1image').src = this.PrevieuwCName1.classname + ".png"
			document.getElementById('combat1image').src = this.PrevieuwCName1.classname + ".png"
			console.log(this.PrevieuwCName1.classname + ".png")
		},
		SetPrevieuwC2: function(PrevC){
			var selectsound = document.getElementById('selectsound')
			selectsound.play();
			this.PrevieuwCName2 = PrevC
			this.StartButton();
			document.getElementById('play2image').src = this.PrevieuwCName2.classname + "2.png"
			document.getElementById('combat2image').src = this.PrevieuwCName2.classname + "2.png"
			console.log(this.PrevieuwCName2.classname + ".jpg")
		},
		StartButton: function(){
//			if(Boolean(this.SetPrevieuwC1).classname.contains('')==false && Boolean(this.SetPrevieuwC2).classname.contains('')==false){
				document.getElementById('StartButton').style.display = 'block';
//			}
		},
		StartCombat: function(){
			this.CombatState = true
			
			
			
			setTimeout(this.SetCombat, 100)
		},
		
		SetCombat: function(){
			
			this.P1hpcurrent = this.PrevieuwCName1.hp_current
			this.P2hpcurrent = this.PrevieuwCName2.hp_current
			
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
			
			this.PrevieuwCName1.nickname = Math.random()
			this.PrevieuwCName2.nickname = Math.random()
			
			console.log("player1 id: " + this.PrevieuwCName1.nickname)
			console.log("player2 id: " + this.PrevieuwCName2.nickname)
			
			this.delay(1000)
			
			var audio = document.getElementById('battlemusic')
			audio.play();
		},
		
		LockIn1:function(){
			if(this.Char1ReadyAttack == true){
				document.getElementById('actions1all').style.display = "none"
				this.Char1Ready = true
				this.P1LockedIn = this.Char1AttackPrevieuw
				console.log(this.P1Name + " locked in " + this.P1LockedIn)
				if(this.Char1Ready==true && this.Char2Ready==true){
				setTimeout(this.Attackround, 500)
				}
			}
		},
		
		LockIn2:function(){
			if(this.Char2ReadyAttack == true){
				document.getElementById('actions2all').style.display = "none"
				this.Char2Ready = true
				this.P2LockedIn = this.Char2AttackPrevieuw
				console.log(this.P2Name + " locked in " + this.P2LockedIn)
				if(this.Char1Ready==true && this.Char2Ready==true){
				setTimeout(this.Attackround, 500)
				}
			}
		},
		
		Attackround:function(){
			
			console.log('Round Started')
			console.log("P1: " + this.PrevieuwCName1.classname)
			console.log("P2: " + this.PrevieuwCName2.classname)
			
			if(this.PrevieuwCName1.speed > this.PrevieuwCName2.speed){
				console.log('player 1 is faster')
				this.UseAttack(this.PrevieuwCName1, this.PrevieuwCName2, this.P1LockedIn)
				console.log('player 1 attacked')
				if(this.PrevieuwCName2.hp_current == 0){
					this.Win = this.PrevieuwCName1
					this.Los = this.PrevieuwCName2
					this.MatchOver();
				} else{
					
				this.UseAttack(this.PrevieuwCName2, this.PrevieuwCName1, this.P2LockedIn)
				console.log('player 2 attacked')
					if(this.PrevieuwCName1.hp_current == 0){
					this.Win = this.PrevieuwCName2
					this.Los = this.PrevieuwCName1
					this.MatchOver();
					} 
					if(this.PrevieuwCName2.hp_current == 0){
						this.Win = this.PrevieuwCName1
						this.Los = this.PrevieuwCName2
						this.MatchOver();
					}
				}

				document.getElementById('actions1all').style.display = "block"
				
			} if(this.PrevieuwCName1.speed < this.PrevieuwCName2.speed){
				console.log('player2 is faster')
				this.UseAttack(this.PrevieuwCName2, this.PrevieuwCName1, this.P2LockedIn)
				console.log('player 2 attacked')
				if(this.PrevieuwCName1.hp_current == 0){
					this.Win = this.PrevieuwCName2
					this.Los = this.PrevieuwCName1
				}
				else{

				this.UseAttack(this.PrevieuwCName1, this.PrevieuwCName2, this.P1LockedIn)
				console.log('player1 attacked')
					if(this.PrevieuwCName2.hp_current == 0){
					this.Win = this.PrevieuwCName1
					this.Los = this.PrevieuwCName2
					this.MatchOver();
					}
					if(this.PrevieuwCName1.hp_current == 0){
						this.Win = this.PrevieuwCName1
						this.Los = this.PrevieuwCName2
						this.MatchOver();
					}
				}
				document.getElementById('actions1all').style.display = "block"
		
			} else if(this.PrevieuwCName1.speed == this.PrevieuwCName2.speed){
			console.log('speed is equal')
			this.UseAttack(this.PrevieuwCName1, this.PrevieuwCName2, this.P1LockedIn)
			console.log('player1 attacked')
				if(this.PrevieuwCName2.hp_current == 0){
					this.Win = this.PrevieuwCName1
					this.Los = this.PrevieuwCName2
					this.MatchOver();
				}
				else{
				
				this.UseAttack(this.PrevieuwCName2, this.PrevieuwCName1, this.P2LockedIn)
				console.log('player2 attacked')
					if(this.PrevieuwCName1.hp_current == 0){
					this.Win = this.PrevieuwCName2
					this.Los = this.PrevieuwCName1
					}
					if(this.PrevieuwCName2.hp_current == 0){
						this.Win = this.PrevieuwCName1
						this.Los = this.PrevieuwCName2
						this.MatchOver();
					}
				}
				
			}
			document.getElementById('actions1all').style.display = "block"
			document.getElementById('actions2all').style.display = "block"
			
			
			this.Char1Ready = false;
			this.Char2Ready = false;
			
			console.log('attacks finished')
		},
		
		UseAttack:function(Attacker, target, attack){
			console.log(Attacker.classname + " attacks " + target.classname + " with " + attack.name)
			console.log(attack.attackType)
			if(attack.attackType == "Damage") {
				var succeshits = 0;
				for(var a = 0; a<attack.hits; a++) {
					if(attack.damageType == "Physical") {
				var hit = Math.random()*100;
				console.log("hit : " + hit + " against " + attack.accuracy)
				console.log("attack power: " + attack.power)
				var damage = (((attack.power*((Attacker.strength*0.01)+1)))/2);
				console.log('base damage: ' + damage)
				if (hit <= attack.critrate) {
					console.log(Attacker.classname + " Crit!")
					damage = damage*2;
				}	
				damage = (damage*(1-(target.all_Defence)+(target.physical_Defence)));
			
				if (hit < attack.accuracy-(target.speed*0.1)){
					console.log(target.classname + " hp before " + target.hp_current)
					console.log(damage.toFixed(0))
					target.hp_current -= damage.toFixed(0);
					
					console.log(target.classname + " hp after " + target.hp_current)
					succeshits += 1;
					
					console.log(Attacker.classname + " hit " + target.classname + " with " + attack.name)
				}
			
				else {
					console.log(Attacker.classname + " missed")
				}
				}else if(attack.damageType == "Magic") {
					var hit = Math.random()*100;
					console.log("hit : " + hit + " against " + attack.accuracy)
					var damage = (((attack.power*((Attacker.magic*0.01)+1)))/2);
					if (hit <= attack.critrate) {
						console.log(Attacker.classname + " crit!")
						damage = damage*2;
					}
					damage = (damage*(1-(target.all_Defence)+(target.magical_Defence)));
			
					if (hit < attack.accuracy-(target.speed*0.2)){
						console.log(Attacker.classname + ' hit ' + target.classname + " with " + attack.name)
						target.hp_current -= damage.toFixed(0);
						succeshits += 1;
					}
			
					else {
						console.log(Attacker.classname + " missed!")
					}	
				}
			}
		} else if(attack.attackType == "Buff") {
			if(attack.statboosttype == "Strength") {
				this.strength = this.strength*((attack.statboost/100)+1);
			} else if (attack.statboosttype == "Speed") {
				this.speed = this.speed*((attack.statboost/100)+1);
			} else if (attack.statboosttype == "Magic_D") {
				this.magical_Defence = this.magical_Defence*((attack.statboost/100)+1);
			}else if (attack.statboosttype == "Magic") {
				this.magic = this.magic*((attack.statboost/100)+1);
			}  else if (attack.statboosttype == "Physical_D") {
				this.physical_Defence = this.physical_Defence*((attack.statboost/100)+1);
			}
			console.log("stat increased")
		}
		if(target.hp_current < 0){
			target.hp_current = 0
		}
		if(Attacker.hp_current < 0){
			target.hp_current = 0
		}
		if(Attacker.nickname == this.PrevieuwCName1.nickname){
			this.PrevieuwCName1 = Attacker
			this.PrevieuwCName2 = target
		}
		if(Attacker.nickname == this.PrevieuwCName2.nickname){
			this.PrevieuwCName2 = Attacker
			this.PrevieuwCName1 = target
		}
		
		this.P1hpcurrent = this.PrevieuwCName1.hp_current
		this.P2hpcurrent = this.PrevieuwCName2.hp_current	
		
		document.getElementById('AttackInfoChar1').style.display = "none"
		document.getElementById('AttackInfoChar2').style.display = "none"
	},
		
		MatchOver:function(){
			document.getElementById('winimage').src = this.Win.classname + ".png"
			
			document.getElementById('flex-container-super-combat').style.display = 'none'
			document.getElementById('Endscreen').style.display = 'block'
		},
		
		P1SetAttack:function(){
			document.getElementById('AttackInfoChar1').style.display = "block"
			console.log(event.target.innerHTML)
			var selectedattackvalue = event.target.innerHTML
			var player1attack = this.PrevieuwCName1.attacks
			var SelectedAttack = ''
			for(var a = 0; a<player1attack.length; a++){
				if(player1attack[a].name == selectedattackvalue){
					console.log(player1attack[a])
					console.log(selectedattackvalue + " Selected")
					SelectedAttack = player1attack[a]
				}
			}
			this.Char1AttackPrevieuw = SelectedAttack
			this.Char1ReadyAttack = true
		},
		
		P2SetAttack:function(){
			document.getElementById('AttackInfoChar2').style.display = "block"
			console.log(event.target.innerHTML)
			var selectedattackvalue = event.target.innerHTML
			var player2attack = this.PrevieuwCName2.attacks
			var SelectedAttack = ''
			for(var a = 0; a<player2attack.length; a++){
				if(player2attack[a].name == selectedattackvalue){
					console.log(player2attack[a])
					console.log(selectedattackvalue + " Selected")
					SelectedAttack = player2attack[a]
				}
			}
			this.Char2AttackPrevieuw = SelectedAttack
			this.Char2ReadyAttack = true
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
		
//		LockInP1:function(){
//			this.P1LockedIn = this.Char1ReadyAttack
//			console.log(this.P1LockedIn)
//		},
//		
//		LockInP1:function(){}
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