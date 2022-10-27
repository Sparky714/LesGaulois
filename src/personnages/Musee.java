package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;


	public void donnerTrophee(Gaulois gaulois, Equipement equip) {
		if(nbTrophee >= 200) {
			System.out.println("Le musée est plein ! Il faut l'exposer dans un autre endroit...");
		}else {
			System.out.println("Merci " + gaulois.getNom() + "de ton don de " + equip);
			Trophee trop = new Trophee(gaulois, equip);
			trophees[nbTrophee] = trop;
			nbTrophee ++;
		}
	}

	public String extraireInstructionsCaml(Trophee trophees) {
		if(nbTrophee == 0) {
			return "";
		}else {
			String reponse = "let musee = [ \n";
			for(int i = 0; i < nbTrophee; i++) {
				reponse += "'" + trophees.gauloisNom() + "', '" + this.trophees[i] + "';\n";
			}
			reponse += "]";
			return reponse;
		}
	}

}
