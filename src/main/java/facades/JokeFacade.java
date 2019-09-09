package facades;

import dto.JokeDTO;
import entities.Joke;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private JokeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static JokeFacade getJokeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public long getJokeCount(){
        EntityManager em = getEntityManager();
        try{
            return  (long)em.createQuery("SELECT COUNT(j) FROM Joke j").getSingleResult();
        }finally{  
            em.close();
        }
    }

    public List<JokeDTO> getJokes() {
        EntityManager em = getEntityManager();
        try{
            return em.createQuery("SELECT new dto.JokeDTO(j) FROM Joke j", JokeDTO.class).getResultList();
        }finally{  
            em.close();
        }
    }

    public JokeDTO getJokeById(long id) {
        EntityManager em = getEntityManager();
        try{
            return new JokeDTO(em.find(Joke.class, id));
        }finally{  
            em.close();
        }
    }

    public JokeDTO getJokeRandom() {
        EntityManager em = getEntityManager();
        try{
            int rnd = (new Random().nextInt((int)getJokeCount()));

            return em.createQuery("SELECT new dto.JokeDTO(j) FROM Joke j", JokeDTO.class)
                    .setFirstResult(rnd)
                    .setMaxResults(1)
                    .getSingleResult();
        }finally{  
            em.close();
        }
    }

}
