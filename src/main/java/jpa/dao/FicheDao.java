package jpa.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import jpa.EntityManagerHelper;
import jpa.domain.Fiche;
import jpa.domain.Section;

public class FicheDao extends AbstractJpaDao<Long, Fiche>{
	
	public FicheDao() {
		super(Fiche.class);
	}
	
	public Fiche getFicheLibelle(String libelle) {
		String query = "select f from Fiche as f " + "where f.libelle = :libelle";
		return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).setParameter("libelle", libelle).getSingleResult();
	}
	
	public List<Fiche> getAllUtilisateursSurLesFiches() {
		return EntityManagerHelper.getEntityManager().createNamedQuery("toutLesUtilisateursSurFiches", Fiche.class).getResultList();
	}
	
	/*public void saveFiche(Fiche fiche) {
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(fiche);
		t.commit();
	}
	
	public List<Fiche> getAllFiche() {
		return EntityManagerHelper.getEntityManager().createNamedQuery("toutesLesFiches", Fiche.class).getResultList();
	}*/
}
