package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ClassMemberDTO;
import entities.ClassMember;
import entities.ColorEnum;
import facades.ClassMemberFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Martin
 */
@Path("classmember")
public class ClassMemberResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV,EMF_Creator.Strategy.CREATE);
    private static final ClassMemberFacade FACADE =  ClassMemberFacade.getClassMemberFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        String[] endpoints = {"/all", "/{id}"};
        return "{\"api\":\"classmember\", \"endpoints\":" + GSON.toJson(endpoints)+ "}";
    }
    
    @Path("setup")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String setupDatabase() {
        EntityManager em = EMF.createEntityManager();
        List<ClassMember> ClassMembers = new ArrayList();
        ClassMembers.add(new ClassMember("Martin Frederiksen", "cph-mf237", ColorEnum.RED, "#"));
        ClassMembers.add(new ClassMember("Andreas Vikke", "cph-av105", ColorEnum.RED, "#"));
        
        
        em.getTransaction().begin();
        for(ClassMember cm : ClassMembers)
            em.persist(cm);

        em.getTransaction().commit();
        
        return "{\"status\":\"completed\"}";
    }
    
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getClassMembers() {
        List<ClassMemberDTO> classMembers = FACADE.getClassMembers();
        return GSON.toJson(classMembers);
    }
    
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getJokeById(@PathParam("id") long id) {
        ClassMemberDTO classMember = FACADE.getClassMemberById(id);
        return GSON.toJson(classMember);
    }   
}
