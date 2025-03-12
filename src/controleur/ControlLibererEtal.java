package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer

	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		//TODO a completer
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if(etal != null && etal.isEtalOccupe()) {
		String[] donneesEtal = null;
	
		
		donneesEtal[0] = "true";
		donneesEtal[1] = nomVendeur;
		donneesEtal[2] = etal.getProduit();
		donneesEtal[3] = String.valueOf(etal.getQuantite());
		donneesEtal[4] = String.valueOf(etal.getQuantiteDebMarche() - etal.getQuantite());

		// Libérer l’étal
		etal.libererEtal();

		return donneesEtal;
		} else {
		// Retourne un tableau indiquant que l'étal n'était pas occupé
		return new String[]{"false"};
				}
			}
	}
