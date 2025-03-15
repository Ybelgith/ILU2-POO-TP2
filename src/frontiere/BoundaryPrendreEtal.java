package frontiere;

import controleur.ControlPrendreEtal;
import frontiere.Clavier;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Vous devez être un villageois pour prendre un étal !");
			return;
		}

		if (!controlPrendreEtal.resteEtals()) {
			System.out.println("Désolé, il n'y a plus d'étal disponible au marché.");
			return;
		}

		installerVendeur(nomVendeur);
	}

	private void installerVendeur(String nomVendeur) {
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");

		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);

		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé avec succès à l'étal n°" + numeroEtal);
		} else {
			System.out.println("Une erreur est survenue, impossible de prendre l'étal.");
		}
	}
}
