package facades;

import dto.JokeDTO;
import utils.EMF_Creator;
import entities.Joke;
import entities.JokeType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class MemeberFacadeTest {

    private static EntityManagerFactory emf;
    private static JokeFacade facade;
    private static List<Joke> jokes = new ArrayList();

    public MemeberFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       facade = JokeFacade.getJokeFacade(emf);
       
       jokes.add(new Joke("What time did the man go to the dentist? Tooth hurt-y.", JokeType.DAD));
       jokes.add(new Joke("Knock knock. Who’s there? Nana. Nana who? Nana your business.", JokeType.KNOCKKNOCK));
       jokes.add(new Joke("Database", JokeType.ASGER));
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            for(Joke joke : jokes)
                em.persist(joke);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @Test
    public void testGetJokeCount() {
        assertEquals(3, facade.getJokeCount(), "Expects three rows in the database");
    }

    @Test
    public void testGetJokes() {
        assertEquals(3, facade.getJokes().size(), "Expects three rows in the database");
    }

    @Test
    public void testGetJokeById() {
        assertEquals(new JokeDTO(jokes.get(0)), facade.getJokeById(jokes.get(0).getId()));
    }
    
    @Test
    public void testGetJokeRandom() {
        JokeDTO joke = facade.getJokeRandom();
        assertNotNull(joke);
    }
}
