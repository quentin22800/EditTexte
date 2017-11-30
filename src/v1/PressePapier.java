package v1;
/***********************************************************************
 * Module:  PressePapier.java
 * Author:  17009495
 * Purpose: Defines the Class PressePapier
 ***********************************************************************/

import java.util.*;

/**
 * Classe PressePapier
 * @author Eono Quentin, Rebours Gaël
 */
public class PressePapier {

	private String contenu;

	
	
	/**
	 * Getter du contenu 
	 * @return contenu, contenu du presse papier
	 */
	public String getContenu() {

		return contenu;
	}

	/**
	 * Setter du contenu
	 * @param contenu, contenu à inserer
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}