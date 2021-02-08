package jpa.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import jpa.EntityManagerHelper;
import jpa.business.Section;

public class SectionDAO {
	public void saveSection(Section section) {
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(section);
		t.commit();
	}
	
	public List<Section> getAllSection() {
		return EntityManagerHelper.getEntityManager().createNamedQuery("toutesLesSections", Section.class).getResultList();
	}

}
