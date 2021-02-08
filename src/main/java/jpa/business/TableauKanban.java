package jpa.business;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TableauxKanban")
@NamedQueries(
		{
			@NamedQuery(name= "toutLesTableauxKanban", 
					query = "select t from TableauKanban as t"),
		}
)
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
