package v3;

import java.util.Stack;

import v1.Ihm;
import v1.MoteurEdImpl;

/**
 * Classe GestionnaireDRImpl, implémentation de l'interface GestionnaireDR.
 * Gère les commandes défaire et refaire
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class GestionnaireDRImpl implements GestionnaireDR{

	private MoteurEdImpl moteur;
	
	private Stack<MoteurEdImpl> etatsUndo;
	private Stack<MoteurEdImpl> etatsRedo;
	
	/**
	 * Constructeur de la classe GestionnaireDRImpl
	 * @param moteur Implémentation du moteur d'édition de notre application
	 */
	public GestionnaireDRImpl(MoteurEdImpl moteur) {
		super();
		this.etatsUndo = new Stack<MoteurEdImpl>();
		this.etatsRedo = new Stack<MoteurEdImpl>();
		this.moteur = moteur;
	}

	/**
	 * Implémentation de la commande defaire,
	 * vérifie que la pile d'états "defaire" n'est pas vide puis récupère le dernier
	 * état ajouté, le push dans la pile refaire puis recharge les paramètre du moteur actuel avec ces nouveaux paramètres
	 */
	@Override
	public void defaire() {
		if(!etatsUndo.isEmpty()){
			MoteurEdImpl m = etatsUndo.pop();
			if(m != null){
				etatsRedo.push(m);
				changeMoteur(m);
			}
		}
		
	}

	/**
	 * Implémentation de la commande refaire,
	 * vérifie que la pile d'états "refaire" n'est pas vide puis récupère le dernier
	 * état ajouté, recharge les paramètre du moteur actuel avec ces nouveaux paramètres
	 */
	@Override
	public void refaire() {
		if(!etatsRedo.isEmpty()){
			MoteurEdImpl m = etatsRedo.pop();
			if(m != null){
				changeMoteur(m);
			}
		}
	}
	
	/**
	 * Méthode enregistrerEtat, permet d'enregistrer un état;
	 * on vide la pile de "refaire" a chaque enregistrement
	 */
	public void enregistrerEtat(){
		etatsUndo.push(moteur.getCopie());
		etatsRedo.clear();
	}
	
	/**
	 * Méthode changeMoteur, permt de changer les paramètre du moteur actuel
	 * @param moteurP moteur qui contient les paramètres à charger
	 */
	private void changeMoteur(MoteurEdImpl moteurP){
		this.moteur.getMaSelection().selectionUpdate(moteurP.getMaSelection().getPositionDebut(), moteurP.getMaSelection().getLongueur());
		this.moteur.getMonBuffer().inserer(moteurP.getMonBuffer().getZoneTexte().toString(), 0, moteur.getMonBuffer().getZoneTexte().length());
		this.moteur.getMonPressePapier().setContenu(moteurP.getMonPressePapier().getContenu());
		this.moteur.setChange(moteurP.getMonBuffer().getZoneTexte());
	}

	/**
	 * Getter de la pile des états à defaire
	 * @return etatsUndo, pile des états à defaire
	 */
	public Stack<MoteurEdImpl> getEtatsUndo() {
		return etatsUndo;
	}

	/**
	 * Getter de la pile des états à refaire
	 * @return etatsRedo, pile des états à refaire
	 */
	public Stack<MoteurEdImpl> getEtatsRedo() {
		return etatsRedo;
	}
		
}
