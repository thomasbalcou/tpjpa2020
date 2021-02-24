package jpa.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import jpa.domain.*;
import jpa.EntityManagerHelper;
import jpa.domain.TableauKanban;


public class TableauKanbanDao extends AbstractJpaDao<Long, TableauKanban>{
	
	public TableauKanbanDao() {
		super(TableauKanban.class);
	}
	
	/*public void saveTableau(TableauKanban Tableau) {
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(Tableau);
		t.commit();
	}
	public List<TableauKanban> getAllTableaux() {
		return EntityManagerHelper.getEntityManager().createNamedQuery("toutLesTableauxKanban", TableauKanban.class).getResultList();
	}*/

}
