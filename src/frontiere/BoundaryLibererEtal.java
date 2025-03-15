package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		String[] donnees = controlLibererEtal.libererEtal(nomVendeur);
		if (donnees[0].equals("true")) {
			System.out.println("L'étal de " + donnees[1] + " est libéré. Produit : " + donnees[2] + ", vendu : "
					+ donnees[4] + "/" + donnees[3]);
		} else {
			System.out.println("Vous n'avez aucun étal à libérer.");
		}
	}
}
