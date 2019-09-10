package facades;

import dto.CarDTO;
import entities.Car;
import utils.EMF_Creator;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class CarFacadeTest {

    private static EntityManagerFactory emf;
    private static CarFacade facade;
    private static List<Car> cars = new ArrayList();

    public CarFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       facade = CarFacade.getCarFacade(emf);
       
       cars.add(new Car(1992, "Ford", "E350", 3000, "Martin Frederiksen", 20000));
        cars.add(new Car(1999, "Chevy", "Venture", 4900, "Andreas Vikke", 120000));
        cars.add(new Car(2000, "Chevy", "Venture", 5000, "Martin Frederiksen", 1000));
        cars.add(new Car(1996, "Jeep", "Grand Cherokee", 4799, "Andreas Vikke", 100000));
        cars.add(new Car(2005, "Volvo", "V70", 44799, "Martin Frederiksen", 200000));
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Car.deleteAllRows").executeUpdate();
            for(Car c : cars)
                em.persist(c);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    @Test
    public void testGetCarById() {
        assertEquals(new CarDTO(cars.get(0)).getOwner(), facade.getCarById(cars.get(0).getId()).getOwner());
    }
    
    @Test
    @Disabled
    public void testGetCars(){
        List<CarDTO> carsDTO = new ArrayList();
        for(Car c : cars) {
            carsDTO.add(new CarDTO(c));
        }
        assertTrue(facade.getCars().equals(carsDTO));
    }
}
