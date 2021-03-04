package jaxrs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import jpa.dao.FicheDao;
import jpa.domain.Fiche;
import jpa.domain.Section;
import io.swagger.v3.oas.models.tags.Tag;
import jaxrs.dto.FicheDTO;
import jaxrs.dto.SectionDTO;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/fiche")
public class FicheResource {

	 FicheDao fichedao;
	 
	 public FicheResource() {
		 
		 this.fichedao = new FicheDao();
	 }

	  @GET
	  @Path("/all")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<FicheDTO> getAllFiche()  {
		  List<Fiche> fiches = this.fichedao.findAll();
		  List<FicheDTO> dto = new ArrayList<FicheDTO>();
		  for (Fiche f: fiches) {
			  FicheDTO fichedto=new FicheDTO();
			  fichedto.setLibelle(f.getLibelle());
			  //set tout le reste
			  fichedto.setIdUtilisateur(f.getUtilisateur().getId());
			  dto.add(fichedto);
		}
	      return dto;
	  }
	  
	  @GET
	  @Path("/{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public FicheDTO getOneFiche(@PathParam("id") String id)  {
	     Fiche f=this.fichedao.getFicheLibelle(id);
	     FicheDTO fichedto=new FicheDTO();
	     fichedto.setLibelle(f.getLibelle());
		  //set tout le reste
		 fichedto.setIdUtilisateur(f.getUtilisateur().getId());
		 return fichedto;
	  }
	  
	  @POST
	  @Path("/nouveau")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public FicheDTO createTableau(Fiche fiche) {
		 this.fichedao.save(fiche);
		 Fiche f=this.fichedao.getFicheLibelle(fiche.getLibelle());
	     FicheDTO fichedto=new FicheDTO();
	     fichedto.setLibelle(f.getLibelle());
		  //set tout le reste
		 fichedto.setIdUtilisateur(f.getUtilisateur().getId());
		 return fichedto;
	  }
	  
}
