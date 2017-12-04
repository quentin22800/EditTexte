package v3;

import java.util.Stack;

import v1.Ihm;
import v1.MoteurEdImpl;

public class GestionnaireDRImpl implements GestionnaireDR{

	private MoteurEdImpl moteur;
	
	private Stack<MoteurEdImpl> etatsUndo;
	private Stack<MoteurEdImpl> etatsRedo;
	
	public GestionnaireDRImpl(MoteurEdImpl moteur) {
		super();
		this.etatsUndo = new Stack<MoteurEdImpl>();
		this.etatsRedo = new Stack<MoteurEdImpl>();
		this.moteur = moteur;
	}

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

	@Override
	public void refaire() {
		if(!etatsRedo.isEmpty()){
			MoteurEdImpl m = etatsRedo.pop();
			if(m != null){
				changeMoteur(m);
			}
		}
	}
	
	public void enregistrerEtat(){
		etatsUndo.push(moteur.getCopie());
		etatsRedo.clear();
	}
	
	private void changeMoteur(MoteurEdImpl moteurP){
		this.moteur.getMaSelection().selectionUpdate(moteurP.getMaSelection().getPositionDebut(), moteurP.getMaSelection().getLongueur());
		this.moteur.getMonBuffer().inserer(moteurP.getMonBuffer().getZoneTexte().toString(), 0, moteur.getMonBuffer().getZoneTexte().length());
		this.moteur.getMonPressePapier().setContenu(moteurP.getMonPressePapier().getContenu());
		this.moteur.setChange(moteurP.getMonBuffer().getZoneTexte());
	}

}
