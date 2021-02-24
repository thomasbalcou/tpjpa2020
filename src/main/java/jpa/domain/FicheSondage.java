package jpa.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("oui")
public class FicheSondage extends Fiche{
	private String libelle;
	private Section section;
	private Date dateButoire;
	private String lieu;
	public FicheSondage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FicheSondage(String libelle, Section section) {
		super(libelle, section);
		// TODO Auto-generated constructor stub
	}
	

}
