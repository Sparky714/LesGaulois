package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Romain petitMinus = new Romain("PetitMinus", 6);
		asterix.parler("Bonjour � tous !");
		petitMinus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(petitMinus);
		asterix.frapper(petitMinus);
		asterix.frapper(petitMinus);
	}

}
