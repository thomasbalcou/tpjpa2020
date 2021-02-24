package jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import jpa.EntityManagerHelper;
import jpa.domain.Section;
import jpa.domain.TableauKanban;

public class SectionDao extends AbstractJpaDao<Long, Section>{
	
	public SectionDao() {
		super(Section.class);
	}
	
	/*public void saveSection(Section section) {
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(section);
		t.commit();
	}
	
	public List<Section> getAllSection() {
		return EntityManagerHelper.getEntityManager().createNamedQuery("toutesLesSections", Section.class).getResultList();
	}*/
	
	public List<Section> getAllSectionCriteriaQuery() {
		  
		EntityManager em = EntityManagerHelper.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Section> q = cb.createQuery(Section.class);
		Root<Section> c = q.from(Section.class);
		q.select(c);
		TypedQuery<Section> query = em.createQuery(q);
		List<Section> results = query.getResultList();
		return results;
		
		

	}

}
