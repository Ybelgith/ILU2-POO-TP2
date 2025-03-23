package controleur;

import villagegaulois.Etal;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		if (vendeur != null) {
			return village.rechercherEtal(vendeur);
		}
		return null;
	}
}
