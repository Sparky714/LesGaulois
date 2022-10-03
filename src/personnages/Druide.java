package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
			
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le Druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + " .");
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}
	
	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	
	public void preparerPotion(Gaulois gaulois) {
		Random rand = new Random();
		int int_rand = rand.nextInt(effetPotionMax);
		while(int_rand < effetPotionMin) {
			int_rand = rand.nextInt(effetPotionMax);
		}
		if(int_rand > 7) {
			parler("J'ai préparé une super potion de force de " + int_rand);
			gaulois.boirePotion(int_rand);
		}else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + int_rand);
			gaulois.boirePotion(int_rand);
		}
	}
	
	public void booster(Gaulois gaulois) {
		if(gaulois.getNom()=="Obélix") {
			parler("Non Obélix ! Tu n'auras pas de potion magique !");
		}else {
			preparerPotion(gaulois);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Gaulois asterix = new Gaulois("Astérix", 8);
		panoramix.preparerPotion(asterix);
	}
}
