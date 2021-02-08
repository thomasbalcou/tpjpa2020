package jpa.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import jpa.EntityManagerHelper;
import jpa.business.Fiche;

public class FicheDAO {
	
	public void saveFiche(Fiche fiche) {
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(fiche);
		t.commit();
	}
	
	public Fiche getFicheLibelle(String libelle) {
		String query = "select f from Fiche as f " + "where f.libelle = :libelle";
		return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).setParameter("libelle", libelle).getSingleResult();
	}
	
	public List<Fiche> getAllMagter() {
		return EntityManagerHelper.getEntityManager().createNamedQuery("toutesLesFiches", Fiche.class).getResultList();
	}
}
