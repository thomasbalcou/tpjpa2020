package jpa.business;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TableauxKanban")
public class TableauKanban {
	
	private long id;
	private String name;
	private List<Section> sections = new ArrayList <Section>();
	
	public TableauKanban() {
	}
	
	public TableauKanban(String name) {
		this.name=name;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "tableauKanban", cascade = CascadeType.PERSIST)
	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
