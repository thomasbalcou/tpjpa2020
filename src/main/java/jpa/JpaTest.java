package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import jpa.dao.*;
import jpa.domain.Fiche;
import jpa.domain.FicheSondage;
import jpa.domain.Section;
import jpa.domain.TableauKanban;

public class JpaTest {
	
	private EntityManager manager;
	
	public JpaTest(EntityManager manager) {
		this.manager=manager;
	}
	
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		//tx.begin();


		try {
			test.createTableauKanban();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//tx.commit();

		test.listSection();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}

	
	private void createTableauKanban() {
		TableauKanbanDao tdao=new TableauKanbanDao();
		//int nbTableauKanban = tdao.getAllTableaux().size();
		int nbTableauKanban = tdao.findAll().size();
		if(nbTableauKanban == 0) {
			TableauKanban tableauKanban = new TableauKanban("TableauParDefaut");
			tdao.save(tableauKanban);
			SectionDao sdao = new SectionDao();
			Section ea=new Section("en attente",tableauKanban);
			Section ec=new Section("en cours",tableauKanban);
			Section r=new Section("realise",tableauKanban);
			sdao.save(ea);
			sdao.save(ec);
			sdao.save(r);
		}
	}
		
	private void listSection() {
		SectionDao sdao = new SectionDao();
		List<Section> resultList = sdao.getAllSectionCriteriaQuery();
		System.out.println("nombres de sections:" + resultList.size());
			for(Section s: resultList) {
				System.out.println("Section suivante:" + s.getType());
			}
		}

}