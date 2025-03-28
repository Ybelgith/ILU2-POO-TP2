package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}


	public String[] trouverVendeursProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		if (vendeurs == null) return new String[0];
		String[] nomsVendeurs = new String[vendeurs.length];
		for (int i = 0; i < vendeurs.length; i++) {
			nomsVendeurs[i] = vendeurs[i].getNom();
		}
		return nomsVendeurs;
	}


	public Etal trouverEtalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public int acheterProduit(String nomVendeur, int quantiteSouhaitee) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal != null) {
			return etal.acheterProduit(quantiteSouhaitee);
		}
		return 0;
	}
}
