package v3.commands;

import v1.commands.Command;
import v3.GestionnaireDRImpl;

/**
 * Classe Refaire, implémentation de la commande concrète "Refaire"
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class Refaire implements Command{
	
	private GestionnaireDRImpl gestionnaireDRImpl;

	/**
	 * Constructeur de la commande Refaire
	 * @param gestionnaireDRImpl gestionnaire des commandes refaire et defaire
	 */
	public Refaire(GestionnaireDRImpl gestionnaireDRImpl){
		this.gestionnaireDRImpl = gestionnaireDRImpl;
	}
	
	/**
	 * Méthode execute, fait appel à la méthode "refaire" de l'enregistreur
	 */
	@Override
	public void execute() {
		gestionnaireDRImpl.refaire();
	}

}
