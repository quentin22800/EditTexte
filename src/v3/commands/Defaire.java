package v3.commands;

import v1.commands.Command;
import v3.GestionnaireDRImpl;

/**
 * Classe Defaire, implémentation de la commande concrète "defaire"
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class Defaire implements Command{

	private GestionnaireDRImpl gestionnaireDRImpl;
	
	/**
	 * Constructeur de la commande Defaire
	 * @param gestionnaireDRImpl gestionnaire des commandes refaire et defaire
	 */
	public Defaire(GestionnaireDRImpl gestionnaireDRImpl){
		this.gestionnaireDRImpl = gestionnaireDRImpl;
	}
	
	/**
	 * Méthode execute, fait appel à la méthode "defaire" de l'enregistreur
	 */
	@Override
	public void execute() {
		gestionnaireDRImpl.defaire();
	}

}
