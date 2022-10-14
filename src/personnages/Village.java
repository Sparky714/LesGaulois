package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	private Gaulois [] villageois;
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		villageois  = new Gaulois[nbVillageoisMaximum];
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if(nbVillageois >= nbVillageoisMaximum) {
			System.out.println("Il n'y a plus de place dans ce village !");
		}else {
			villageois[nbVillageois] = gaulois;
			nbVillageois += 1;
		}
	}
	
	public Gaulois trouverHabitant(int numerobis) {
		return villageois[numerobis];
	}
	
	public void afficherVillageois(Village village) {
		System.out.println("Dans le village du chef " + village.chef.getNom() + " vivent les légendaires gaulois : " + "\n");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(villageois[i].getNom());
			}
		}
	
	public static void main(String[] args) {
		Village villageDesIrreductibles = new Village("Village des Irréductibles", 30);
		/*Gaulois gaulois = villageDesIrreductibles.trouverHabitant(30);
	 Le tableau est vide, donc récupérer le 31ième habitant n'est pas possible. De plus, on ne peut récupérer le 31 car on en a au max 30*/
		Chef abraracourcix = new Chef("Abraracourcix", 8, 0, villageDesIrreductibles);
		villageDesIrreductibles.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		villageDesIrreductibles.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Obélix", 25);
		villageDesIrreductibles.ajouterHabitant(obelix);
		villageDesIrreductibles.afficherVillageois(villageDesIrreductibles);
		/*Gaulois gaulois = villageDesIrreductibles.trouverHabitant(1);
		System.out.println(gaulois);
		 On récupère le gaulois à l'indice 1 du tableau, et on l'affiche avec la méthode toString de Gaulois*/
	}
}