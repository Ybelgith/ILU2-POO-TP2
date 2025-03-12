package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		return village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		//TODO a completer
		if (!verifierIdentite(nomVendeur)) {
			return -1; // Identité non valide
		}

		// Trouver l'habitant dans le village
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		if (vendeur == null) {
			return -1; // Le vendeur n'existe pas
		}

		// Demander au village de donner un étal libre
		int numeroEtal = village.installerVendeur(vendeur, produit, nbProduit);
		return numeroEtal;
	}
		
	

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
