package facades;

import dto.ClassMemberDTO;
import entities.ColorEnum;
import utils.EMF_Creator;
import entities.ClassMember;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class ClassMemberFacadeTest {

    private static EntityManagerFactory emf;
    private static ClassMemberFacade facade;
    private static List<ClassMember> classMembers = new ArrayList();

    public ClassMemberFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       facade = ClassMemberFacade.getClassMemberFacade(emf);
       
       classMembers.add(new ClassMember("Martin Frederiksen", "cph-mf237", ColorEnum.RED,  "#"));
       classMembers.add(new ClassMember("Andreas Vikke", "cph-av105", ColorEnum.RED, "#"));
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("ClassMember.deleteAllRows").executeUpdate();
            for(ClassMember m : classMembers)
                em.persist(m);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    @Test
    public void testGetClassMember() {
        assertEquals(new ClassMemberDTO(classMembers.get(0)).getName(), facade.getClassMemberById(classMembers.get(0).getId()).getName());
    }
    
    @Test
    @Disabled
    public void testGetClassMembers(){
        List<ClassMemberDTO> membersDTO = new ArrayList();
        for(ClassMember m : classMembers) {
            membersDTO.add(new ClassMemberDTO(m));
        }
        assertEquals(2, facade.getClassMembers().size());
    }
}