package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CarDTO;
import dto.ClassMemberDTO;
import entities.Car;
import entities.ClassMember;
import entities.ColorEnum;
import facades.CarFacade;
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
@Path("car")
public class CarResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final CarFacade FACADE = CarFacade.getCarFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        String[] endpoints = {"/all", "/{id}"};
        return "{\"api\":\"classmember\", \"endpoints\":" + GSON.toJson(endpoints) + "}";
    }

    @Path("setup")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String setupDatabase() {
        EntityManager em = EMF.createEntityManager();
        List<Car> cars = new ArrayList();
        cars.add(new Car(1992, "Ford", "E350", 3000, "Martin Frederiksen", 20000));
        cars.add(new Car(1999, "Chevy", "Venture", 4900, "Andreas Vikke", 120000));
        cars.add(new Car(2000, "Chevy", "Venture", 5000, "Martin Frederiksen", 1000));
        cars.add(new Car(1996, "Jeep", "Grand Cherokee", 4799, "Andreas Vikke", 100000));
        cars.add(new Car(2005, "Volvo", "V70", 44799, "Martin Frederiksen", 200000));

        em.getTransaction().begin();
        for (Car c : cars) {
            em.persist(c);
        }

        em.getTransaction().commit();

        return "{\"status\":\"completed\"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCars() {
        List<CarDTO> cars = FACADE.getCars();
        return GSON.toJson(cars);
    }

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCarById(@PathParam("id") long id) {
        CarDTO car = FACADE.getCarById(id);
        return GSON.toJson(car);
    }
}