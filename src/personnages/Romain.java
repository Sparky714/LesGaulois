package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipement = new Equipement[2];
	private int nbEquipement = 0;
	public Romain(String nom, int force) {
		assert force > 0;
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}
	
	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forceDeb = force;
		force -= forceCoup;
		if (force > 0 ) {
			parler("Aïe");
		}else {
			parler("J'abandonne");
		}
		assert forceDeb > force;
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force +  "]";
	}
	
	public void sEquiper(Romain romain, Equipement equip) {
		switch(nbEquipement) {
		case 2:
			System.out.println("Le soldat " + romain.getNom() + " est déjà bien équipé !");
			break;
		case 1:
			if(equip == equipement[0]) {
				System.out.println("Le soldat " + romain.getNom() + " est déjà équipé d'un " + equip + " !");
				break;
			}else {
				System.out.println("Le soldat " + romain.getNom() + " s'équipe avec un " + equip + " !");
				equipement[1] = equip;
				nbEquipement += 1;
				break;
			}
		default:
			System.out.println("Le soldat " + romain.getNom() + " s'équipe avec un " + equip + " !");
			equipement[0] = equip;
			nbEquipement += 1;
			break;
		}
	}
	
	public static void main(String[] args) {
		//TODO créer un main permettant de tester la classe Gaulois
		Romain PetitMinus = new Romain("PetitMinus", 6);
		System.out.println(PetitMinus);
		PetitMinus.parler("Bonjour !");
		PetitMinus.recevoirCoup(12);
		PetitMinus.sEquiper(PetitMinus, Equipement.CASQUE);
		PetitMinus.sEquiper(PetitMinus, Equipement.CASQUE);
		PetitMinus.sEquiper(PetitMinus, Equipement.BOUCLIER);
		PetitMinus.sEquiper(PetitMinus, Equipement.CASQUE);
	}
	
}
