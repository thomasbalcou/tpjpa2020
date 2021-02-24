package jpa.domain;

import java.util.Set;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="sondage")
@DiscriminatorValue("non")
@Table(name = "Fiches")
@NamedQueries(
		{
			@NamedQuery(name= "toutesLesFiches", 
					query = "select f from Fiche as f"),
			
			@NamedQuery(name= "toutLesUtilisateursSurFiches", 
					query = "select f.utilisateur from Fiche as f"),
		}
		)
public class Fiche implements Serializable{
	
	private String libelle;
	private Section section;
	private Date dateButoire;
	private String lieu;
	private Utilisateur utilisateur;
	private int tempsMinute;
	private Set<Tag> tags = new HashSet<Tag>();
	private String url;
	private String note;
	
	public Fiche() {
	}
	
	
	public Fiche(String libelle, Section section) {
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
