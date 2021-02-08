package jpa.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import jpa.EntityManagerHelper;
import jpa.business.TableauKanban;


public class TableauKanbanDAO {
	public void saveTableau(TableauKanban Tableau) {
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(Tableau);
		t.commit();
	}
	public List<TableauKanban> getAllTableaux() {
		return EntityManagerHelper.getEntityManager().createNamedQuery("toutLesTableauxKanban", TableauKanban.class).getResultList();
	}

}
