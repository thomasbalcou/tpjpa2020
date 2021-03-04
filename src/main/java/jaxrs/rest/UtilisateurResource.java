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

import jaxrs.dto.UtilisateurDTO;
import jpa.dao.UtilisateurDao;
import jpa.domain.Utilisateur;


public class UtilisateurResource {
	
	 UtilisateurDao utidao;
	 
	 public UtilisateurResource() {
		 
		 this.utidao = new UtilisateurDao();
	 }
	 
	  @GET
	  @Path("/all")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<UtilisateurDTO> getAllUti()  {
		  List<Utilisateur> utis = this.utidao.findAll();
		  List<UtilisateurDTO> dto = new ArrayList<UtilisateurDTO>();
		  for (Utilisateur uti :utis) {
			  UtilisateurDTO utidto=new UtilisateurDTO();
			  utidto.setNom(uti.getNom());
			  utidto.setPrenom(uti.getPrenom());
			  dto.add(utidto);
		}
	      return dto;
	  }
	  
	  @GET
	  @Path("/{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public UtilisateurDTO getOneUti(@PathParam("id") long id)  {
	     Utilisateur uti =this.utidao.findOne(id);
	     UtilisateurDTO utidto=new UtilisateurDTO();
		  utidto.setNom(uti.getNom());
		  utidto.setPrenom(uti.getPrenom());
		 return utidto;
	  }
	  
	  @POST
	  @Path("/nouveau")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public UtilisateurDTO createTableau(Utilisateur utilisateur) {
		 this.utidao.save(utilisateur);
		 Utilisateur uti =this.utidao.findOne(utilisateur.getId());
	     UtilisateurDTO utidto=new UtilisateurDTO();
		 utidto.setNom(uti.getNom());
		 utidto.setPrenom(uti.getPrenom());
		 return utidto;
	  }
	  

}
