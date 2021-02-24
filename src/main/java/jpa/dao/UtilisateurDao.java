package jpa.dao;

import jpa.domain.TableauKanban;
import jpa.domain.Utilisateur;

public class UtilisateurDao extends AbstractJpaDao<Long, Utilisateur>{
	
	public UtilisateurDao() {
		super(Utilisateur.class);
	}

}
