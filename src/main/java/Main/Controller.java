package Main;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Klasses.FighterClass;
import Skills.Attack;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Controller {
	General G = new General();

	@GetMapping("/")
	public void Index(){
		G.filloutclasses();
	}	
		
	@GetMapping("/Playerchoose")
	public String Index1(@RequestParam String P1, @RequestParam String P2) {
		String result = G.playernames(P1, P2);
		return result;
	}
	
	@GetMapping("/GetClasses")
		public ArrayList<FighterClass> Index2() {
		return G.filloutclasses();
	}
	@GetMapping("/Round")
		public ArrayList<FighterClass> Index3(@RequestParam FighterClass Attacker, @RequestParam FighterClass Target, @RequestParam Attack attack) {
		return G.useAttack(Attacker, Target, attack);
	}
}
