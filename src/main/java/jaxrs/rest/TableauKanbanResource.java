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

import jaxrs.dto.TableauKanbanDTO;
import jpa.dao.TableauKanbanDao;
import jpa.domain.TableauKanban;

@Path("/tableau")
public class TableauKanbanResource {

		 		
		 TableauKanbanDao tabdao;
		 
		 public TableauKanbanResource() {
			 
			 this.tabdao = new TableauKanbanDao();
		 }
		 
		  @GET
		  @Path("/all")
		  @Produces(MediaType.APPLICATION_JSON)
		  public List<TableauKanbanDTO> getAllTab()  {
			  List<TableauKanban> tabs = this.tabdao.findAll();
			  List<TableauKanbanDTO> dto = new ArrayList<TableauKanbanDTO>();
			  for (TableauKanban tab:tabs) {
				  TableauKanbanDTO tabdto=new TableauKanbanDTO();
				  tabdto.setName(tab.getName());
				  tabdto.setSections(tab.getSections());
				  dto.add(tabdto);
			}
		      return dto;
		  }
		  
		  @GET
		  @Path("/{id}")
		  @Produces(MediaType.APPLICATION_JSON)
		  public TableauKanbanDTO getOneTab(@PathParam("id") long id)  {
		     TableauKanban tab =this.tabdao.findOne(id);
		     TableauKanbanDTO dto = new TableauKanbanDTO();
		     dto.setName(tab.getName());
		     dto.setSections(tab.getSections());
			 return dto;
		  }
		  
		  @POST
		  @Path("/nouveau")
		  @Produces(MediaType.APPLICATION_JSON)
		  @Consumes(MediaType.APPLICATION_JSON)
		  public TableauKanbanDTO createTableau(TableauKanban tableau) {
			 this.tabdao.save(tableau);
			 TableauKanban tab =this.tabdao.findOne(tableau.getId());
		     TableauKanbanDTO dto = new TableauKanbanDTO();
		     dto.setName(tab.getName());
		     dto.setSections(tab.getSections());
			 return dto;
		  }
		  
}

