package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import jpa.business.Fiche;
import jpa.business.FicheSondage;
import jpa.business.Section;
import jpa.business.TableauKanban;
import jpa.dao.*;

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
		TableauKanbanDAO tdao=new TableauKanbanDAO();
		int nbTableauKanban = tdao.getAllTableaux().size();
		if(nbTableauKanban == 0) {
			TableauKanban tableauKanban = new TableauKanban("TableauParDefaut");
			tdao.saveTableau(tableauKanban);
			SectionDAO sdao = new SectionDAO();
			Section ea=new Section("en attente",tableauKanban);
			Section ec=new Section("en cours",tableauKanban);
			Section r=new Section("realise",tableauKanban);
			sdao.saveSection(ea);
			sdao.saveSection(ec);
			sdao.saveSection(r);
		}
	}
		
	private void listSection() {
		SectionDAO sdao = new SectionDAO();
		List<Section> resultList = sdao.getAllSection();
		System.out.println("nombres de sections:" + resultList.size());
			for(Section s: resultList) {
				System.out.println("Section suivante:" + s.getType());
			}
		}

}