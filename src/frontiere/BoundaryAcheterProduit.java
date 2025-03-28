package frontiere;

import controleur.ControlAcheterProduit;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolé(e) " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}

		System.out.println("Quel produit voulez-vous acheter ?");
		String produit = Clavier.entrerChaine("");

		String[] vendeurs = controlAcheterProduit.trouverVendeursProduit(produit);
		if (vendeurs.length == 0) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
			return;
		}

		System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
		for (int i = 0; i < vendeurs.length; i++) {
			System.out.println((i + 1) + " - " + vendeurs[i]);
		}

		int choixVendeur = Clavier.entrerEntier("") - 1;
		String nomVendeur = vendeurs[choixVendeur];
		Etal etal = controlAcheterProduit.trouverEtalVendeur(nomVendeur);

		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
		System.out.println("Bonjour " + nomAcheteur);
		System.out.println("Combien de " + produit + " voulez-vous acheter ?");
		int quantite = Clavier.entrerEntier("");

		int quantiteAchetee = etal.acheterProduit(quantite);
		if (quantiteAchetee == 0) {
			System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !");
		} else if (quantiteAchetee < quantite) {
			System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteAchetee + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
		} else {
			System.out.println(nomAcheteur + " achète " + quantiteAchetee + " " + produit + " à " + nomVendeur);
		}
	}
}
