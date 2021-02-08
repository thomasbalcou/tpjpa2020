package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import jpa.business.Fiche;
import jpa.business.Section;
import jpa.business.TableauKanban;

public class JpaTest {
	
	private EntityManager manager;
	
	public JpaTest(EntityManager manager) {
		this.manager=manager;
	}
	
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			test.createTableauKanban();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listSection();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}

	
	private void createTableauKanban() {
		int nbTableauKanban= manager.createQuery("Select a From TableauKanban a", TableauKanban.class).getResultList().size();
		if(nbTableauKanban == 0) {
			TableauKanban tableauKanban = new TableauKanban("TableauParDefaut");
			manager.persist(tableauKanban);
			manager.persist(new Section("en attente",tableauKanban));
			manager.persist(new Section("en cours",tableauKanban));
			manager.persist(new Section("realise",tableauKanban));
		}
	}
		
	private void listSection() {
		List<Section> resultList = manager.createQuery("Select a From Section a", Section.class).getResultList();
		System.out.println("nombres de sections:" + resultList.size());
			for(Section s: resultList) {
				System.out.println("Section suivante:" + s.getType());
			}
		}
}