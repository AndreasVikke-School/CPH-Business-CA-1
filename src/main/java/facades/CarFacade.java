package facades;

import dto.CarDTO;
import entities.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Martin
 */
public class CarFacade {
    
    private static CarFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private CarFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CarFacade getCarFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CarFacade();
        }
        return instance;
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CarDTO getCarById(long id) {
        return new CarDTO(getEntityManager().find(Car.class, id));
    }

    public List<CarDTO> getCars() {
        return getEntityManager().createQuery("SELECT new dto.CarDTO(c) FROM Car c", CarDTO.class).getResultList();
    }
    
}
