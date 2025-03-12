package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					//TODO a completer
					emmenagerGaulois(nomVisiteur);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue"+ nomVisiteur + "!");
		int force = Clavier.entrerEntier("Quelle est votre force?");
		int effetPotionMin  = Clavier.entrerEntier("Quel est l'effet min de votre potion magique?");
		int effetPotionMax;
		do {
			effetPotionMax = Clavier.entrerEntier("Quelle est l'eefet max de votre potion magique?");
			if(effetPotionMax < effetPotionMin) {
				System.out.println("L'effet de votre potion max doit être > à l'effet min !");}
		} while(effetPotionMax < effetPotionMin); 
			
			controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
			System.out.println("Ajout de" + nomVisiteur + "!");
				
		
	}
	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenue" + nomVisiteur +"!");
		int force = Clavier.entrerEntier("Quelle est votre force?");
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
		System.out.println("Ajout de" + nomVisiteur + "!");
		
	}
		
}

