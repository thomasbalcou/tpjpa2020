package jpa.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name = "Tags")
public class Tag {
	
	private String nom;
	private List<Fiche> fiches = new ArrayList<Fiche>();
	
	public Tag() {
		
	}
	
	public Tag(String nom) {
		this.nom=nom;
	}
	
	@Id
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@ManyToMany
	public List<Fiche> getFiches() {
		return fiches;
	}

	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}
	
}
