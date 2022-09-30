package personnages;

public class Romain {
	private String nom;
	private int force;
	public Romain(String nom, int force) {
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
		force -= forceCoup;
		if (force > 0 ) {
			parler("Aïe");
		}else {
			parler("J'abandonne");
		}
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force +  "]";
	}
	
	public static void main(String[] args) {
		//TODO créer un main permettant de tester la classe Gaulois
		Romain PetitMinus = new Romain("PetitMinus", 2);
		System.out.println(PetitMinus);
		PetitMinus.parler("Bonjour !");
		PetitMinus.recevoirCoup(12);
	}
	
}
