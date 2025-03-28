package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Quelle est votre force ?");
		int force = Clavier.entrerEntier("");
		System.out.println("Quel est l'effet minimum de vos potions ?");
		int effetMin = Clavier.entrerEntier("");
		System.out.println("Quel est l'effet maximum de vos potions ?");
		int effetMax = Clavier.entrerEntier("");
		
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetMin, effetMax);
		System.out.println("Le druide " + nomVisiteur + " a bien emménagé dans le village.");
	}

	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Quelle est votre force ?");
		int force = Clavier.entrerEntier("");
		
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
		System.out.println("Le gaulois " + nomVisiteur + " a bien emménagé dans le village.");
	}
}

