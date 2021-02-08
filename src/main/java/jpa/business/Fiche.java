package jpa.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.*;

@Entity
@Table(name = "Fiches")
public class Fiche {
	
	private String libelle;
	private Section section;
	private Date dateButoire;
	private Utilisateur utilisateur;
	private int tempsMinute;
	private Set<Tag> tags = new HashSet<Tag>();
	private String lieu;
	private String url;
	private String note;
	
	public Fiche() {
	}
	
	
	public Fiche(String libelle, Section section) {
		super();
		this.libelle = libelle;
		this.section = section;
	}

	@Id
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@ManyToOne
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateButoire() {
		return dateButoire;
	}

	public void setDateButoire(Date dateButoire) {
		this.dateButoire = dateButoire;
	}
	
	@OneToOne(mappedBy = "fiche")
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getTempsMinute() {
		return tempsMinute;
	}

	public void setTempsMinute(int tempsMinute) {
		this.tempsMinute = tempsMinute;
	}
	
	@ManyToMany(mappedBy="fiches")
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}



	
}
