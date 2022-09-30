package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "�" + texte + "�");
	}
	
	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + "envoie un grand coup dans la gueule de " + romain.getNom());
		romain.recevoirCoup(force/3);
	}
	
	public void boirePotion(int forcePot) {
		effetPotion += forcePot;
		parler("Merci Druide, je sens que ma force est " + forcePot + " fois d�cupl�e");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		//TODO cr�er un main permettant de tester la classe Gaulois
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Romain petitMinus = new Romain("PetitMinus", 6);
		System.out.println(asterix);
		asterix.parler("Bonjour !");
		asterix.frapper(petitMinus);
		asterix.boirePotion(12);
	}
}
