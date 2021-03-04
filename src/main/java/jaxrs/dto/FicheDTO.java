package jaxrs.dto;

import java.util.Date;
import jpa.domain.Section;

public class FicheDTO {
	
	private String libelle;
	private Section section;
	private Date dateButoire;
	private String lieu;
	private Long idUtilisateur;
	private int tempsMinute;
	private String url;
	private String note;
	
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Date getDateButoire() {
		return dateButoire;
	}
	public void setDateButoire(Date dateButoire) {
		this.dateButoire = dateButoire;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public int getTempsMinute() {
		return tempsMinute;
	}
	public void setTempsMinute(int tempsMinute) {
		this.tempsMinute = tempsMinute;
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
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
}
