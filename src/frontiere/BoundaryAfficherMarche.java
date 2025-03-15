package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est actuellement vide.");
			return;
		}
		System.out.println("Voici les produits disponibles au marché :");
		for (int i = 0; i < infosMarche.length; i += 3) {
			System.out.println("- " + infosMarche[i] + " vend " + infosMarche[i + 1] + " " + infosMarche[i + 2]);
		}
	}
}
