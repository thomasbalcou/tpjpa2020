package jaxrs.dto;

import java.util.ArrayList;
import java.util.List;

import jpa.domain.Fiche;
import jpa.domain.Section;

public class SectionDTO {
	
	String type;
	List<String> fiches = new ArrayList<String>();
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getFiche() {
		return fiches;
	}
	public void setFiche(List<Fiche> fiches) {
		for(Fiche f:fiches) {
			this.fiches.add(f.getLibelle());
		}
	}

	
}
