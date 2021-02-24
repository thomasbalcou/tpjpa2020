package jpa.domain;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Sections")
@NamedQueries(
		{
			@NamedQuery(name= "toutesLesSections", 
					query = "select s from Section as s"),
		}
		)
public class Section implements Serializable{
	
	private long id;
	private String type;
	private TableauKanban tableauKanban;
	private List <Fiche> fiches = new ArrayList<Fiche>();
	
	public Section() {
	}
	
	public Section(String type, TableauKanban tableauKanban) {
		this.type=type;
		this.tableauKanban=tableauKanban;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToOne
	public TableauKanban getTableauKanban() {
		return tableauKanban;
	}

	public void setTableauKanban(TableauKanban tableauKanban) {
		this.tableauKanban = tableauKanban;
	}
	
	@OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
	public List<Fiche> getFiches() {
		return fiches;
	}

	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}
}
