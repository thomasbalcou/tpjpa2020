package jaxrs.dto;

import java.util.ArrayList;
import java.util.List;

import jpa.domain.Section;

public class TableauKanbanDTO {
	
	String name;
	List<String> sections = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		for(Section s:sections) {
			this.sections.add(s.getType());
		}
	}
	
	
	
}
