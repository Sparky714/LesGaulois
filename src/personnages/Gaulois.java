package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}

	//	private String prendreParole() {
	//		return "Le Gaulois " + nom + " : ";
	//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	//	public void frapper(Romain romain) {
	//		System.out.println(nom + "envoie un grand coup dans la gueule de " + romain.getNom());
	//		romain.recevoirCoup(force/3);
	//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la gueule de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}


	public void boirePotion(int forcePot) {
		effetPotion += forcePot;
		parler("Merci Druide, je sens que ma force est " + forcePot + " fois décuplée");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void faireUneDonation(Musee musee) {
		if(nbTrophees == 0) {
			parler("Je n'ai pas de trophée pour vous...");
		}else {
			parler("Je donne mes trophees au musee : ");
			for(int i = nbTrophees; i > 0 ; i--) {
				System.out.println(trophees[i]);		
				musee.donnerTrophee(this, trophees[i]);
				trophees[i] = null;
			}
		}
	}

	public static void main(String[] args) {
		//TODO créer un main permettant de tester la classe Gaulois
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain petitMinus = new Romain("PetitMinus", 6);
		System.out.println(asterix);
		asterix.parler("Bonjour !");
		asterix.frapper(petitMinus);
		asterix.boirePotion(12);
	}
}
