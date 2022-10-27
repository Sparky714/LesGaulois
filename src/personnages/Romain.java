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

	//	public void recevoirCoup(int forceCoup) {
	//		assert force > 0;
	//		int forceDeb = force;
	//		force -= forceCoup;
	//		if (force > 0 ) {
	//			parler("Aï¿½e");
	//		}else {
	//			parler("J'abandonne");
	//		}
	//		assert forceDeb > force;
	//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// prÃ©condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("AÃ¯e");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == 0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		//		switch (force) {
		//		case 0:
		//		parler("AÃ¯e");
		//		break;
		//		default:
		//		equipementEjecte = ejecterEquipement();
		//		parler("J'abandonne...");
		//		break;
		//		}
		// post condition la force ï¿½ diminuer
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grâce à  mon équipement sa force est diminuée de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + " !";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if(forceCoup < 0) {
			forceCoup =  0;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] != null) {
				equipementEjecte[nbEquipementEjecte] =	equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
				nbEquipement -= 1;
			}
		}
		return equipementEjecte;
	}


	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force +  "]";
	}

	public void sEquiper(Romain romain, Equipement equip) {
		String soldat = "Le soldat ";
		switch(nbEquipement) {
		case 2:
			System.out.println(soldat + romain.getNom() + " est déjà  bien équipé !");
			break;
		case 1:
			if(equip == equipement[0]) {
				System.out.println(soldat + romain.getNom() + " est déjà équipé d'un " + equip + " !");
				break;
			}else {
				System.out.println(soldat + romain.getNom() + " s'équipe avec un " + equip + " !");
				equipement[1] = equip;
				nbEquipement += 1;
				break;
			}
		default:
			System.out.println(soldat + romain.getNom() + " s'équipe avec un " + equip + " !");
			equipement[0] = equip;
			nbEquipement += 1;
			break;
		}
	}

	public static void main(String[] args) {
		//TODO crï¿½er un main permettant de tester la classe Gaulois
		Romain petitMinus = new Romain("PetitMinus", 6);
		System.out.println(petitMinus);
		petitMinus.parler("Bonjour !");
		petitMinus.recevoirCoup(12);
		petitMinus.sEquiper(petitMinus, Equipement.CASQUE);
		petitMinus.sEquiper(petitMinus, Equipement.CASQUE);
		petitMinus.sEquiper(petitMinus, Equipement.BOUCLIER);
		petitMinus.sEquiper(petitMinus, Equipement.CASQUE);
	}

}
