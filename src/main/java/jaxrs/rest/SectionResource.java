package jaxrs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import jaxrs.dto.SectionDTO;
import jaxrs.dto.TableauKanbanDTO;
import jpa.dao.SectionDao;
import jpa.domain.Section;
import jpa.domain.TableauKanban;

@Path("/section")
public class SectionResource {

	 SectionDao sectiondao;
	 
	 public SectionResource() {
		 
		 this.sectiondao = new SectionDao();
	 }

	  @GET
	  @Path("/all")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<SectionDTO> getAllTab()  {
		  List<Section> secs = this.sectiondao.findAll();
		  List<SectionDTO> dto = new ArrayList<SectionDTO>();
		  for (Section sec: secs) {
			  SectionDTO secdto=new SectionDTO();
			  secdto.setType(sec.getType());
			  secdto.setFiche(sec.getFiches());
			  dto.add(secdto);
		}
	      return dto;
	  }
	  
	  @GET
	  @Path("/{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public SectionDTO getOneTab(@PathParam("id") long id)  {
	     Section sec =this.sectiondao.findOne(id);
	     SectionDTO dto = new SectionDTO();
	     dto.setType(sec.getType());
		 dto.setFiche(sec.getFiches());
		 return dto;
	  }
	  
	  @POST
	  @Path("/nouveau")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public SectionDTO createTableau(Section section) {
		 this.sectiondao.save(section);
		 Section sec =this.sectiondao.findOne(section.getId());
	     SectionDTO dto = new SectionDTO();
	     dto.setType(sec.getType());
	     dto.setFiche(sec.getFiches());
		 return dto;
	  }
	  
}
