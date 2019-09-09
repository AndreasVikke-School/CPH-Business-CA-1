package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.JokeDTO;
import entities.Joke;
import entities.JokeType;
import utils.EMF_Creator;
import facades.JokeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("joke")
public class JokeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV,EMF_Creator.Strategy.CREATE);
    private static final JokeFacade FACADE =  JokeFacade.getJokeFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    @Path("setup")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String setupDatabase() {
        EntityManager em = EMF.createEntityManager();
        List<Joke> jokes = new ArrayList();
        jokes.add(new Joke("What time did the man go to the dentist? Tooth hurt-y.", JokeType.DAD));
        jokes.add(new Joke("Knock knock. Who’s there? Nana. Nana who? Nana your business.", JokeType.KNOCKKNOCK));
        jokes.add(new Joke("Database", JokeType.ASGER));
        
        em.getTransaction().begin();
        for(Joke joke : jokes)
            em.persist(joke);

        em.getTransaction().commit();
        
        return "{\"status\":\"completed\"}";
    }
    
    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getJokeCount() {
        long count = FACADE.getJokeCount();
        return "{\"count\":"+count+"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getJokes() {
        List<JokeDTO> jokes = FACADE.getJokes();
        return GSON.toJson(jokes);
    }
    
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getJokeById(@PathParam("id") long id) {
        JokeDTO joke = FACADE.getJokeById(id);
        return GSON.toJson(joke);
    }
    
    @Path("random")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getJokeById() {
        JokeDTO joke = FACADE.getJokeRandom();
        return GSON.toJson(joke);
    }
}
