//ControlPrendreEtal.java
package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
	}

	public boolean resteEtals() {
		return village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		if (vendeur != null && resteEtals()) {
			return village.installerVendeur(vendeur, produit, nbProduit);
		}
		return -1;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}