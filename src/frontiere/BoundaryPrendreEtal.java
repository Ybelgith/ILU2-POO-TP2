package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlPrendreEtal) {
		this.controlPrendreEtal = controlPrendreEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé(e) " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}
		if (!controlPrendreEtal.resteEtals()) {
			System.out.println("Désolé, il n'y a plus d'étals disponibles.");
			return;
		}
		installerVendeur(nomVendeur);
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous.");
		System.out.println("Quel produit souhaitez-vous vendre ?");
		String produit = Clavier.entrerChaine("");
		System.out.println("Combien souhaitez-vous en vendre ?");
		int quantite = Clavier.entrerEntier("");

		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		if (numEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + (numEtal + 1) + ".");
		} else {
			System.out.println("Erreur lors de l'installation du vendeur.");
		}
	}
}