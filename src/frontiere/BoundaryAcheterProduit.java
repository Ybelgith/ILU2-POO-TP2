package frontiere;

import controleur.ControlAcheterProduit;
import frontiere.Clavier;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Vous devez être un villageois pour acheter un produit !");
			return;
		}

		String nomVendeur = Clavier.entrerChaine("Chez quel vendeur voulez-vous acheter ?");
		int quantite = Clavier.entrerEntier("Quelle quantité souhaitez-vous acheter ?");
		int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur, quantite);

		if (quantiteAchetee > 0) {
			System.out.println("Vous avez acheté " + quantiteAchetee + " unité(s) avec succès.");
		} else {
			System.out.println("Achat impossible (stock insuffisant ou vendeur inexistant).");
		}
	}
}
