package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gaulois asterix = new Gaulois("Ast?rix", 8);
		Gaulois obelix = new Gaulois("Ob?lix", 15);
		Romain petitMinus = new Romain("PetitMinus", 6);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		petitMinus.sEquiper(petitMinus, Equipement.CASQUE);
		petitMinus.sEquiper(petitMinus, Equipement.BOUCLIER);
		panoramix.parler("Je vais aller pr?parer une petite potion...");
		panoramix.preparerPotion(asterix);
		panoramix.booster(obelix);
		obelix.parler("Par B?l?nos, ce n'est pas juste !");
		asterix.parler("Bonjour ??tous !");
		petitMinus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(petitMinus);
		asterix.frapper(petitMinus);
		asterix.frapper(petitMinus);
	}

}
