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
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class ClassMemberFacadeTest {

    private static EntityManagerFactory emf;
    private static ClassMemberFacade facade;
    private static List<ClassMember> members = new ArrayList();

    public ClassMemberFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       facade = ClassMemberFacade.getClassMemberFacade(emf);
       
       members.add(new ClassMember("Martin Frederiksen", "cph-mf237", ColorEnum.RED));
       members.add(new ClassMember("Andreas Vikke", "cph-av105", ColorEnum.RED));
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("ClassMember.deleteAllRows").executeUpdate();
            for(ClassMember m : members)
                em.persist(m);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    @Test
    public void testGetMember() {
        assertEquals(new ClassMemberDTO(members.get(0)).getName(), facade.getMember(1L).getName());
    }
    
    @Test
    public void testGetMembers(){
        List<ClassMemberDTO> membersDTO = new ArrayList();
        for(ClassMember m : members) {
            membersDTO.add(new ClassMemberDTO(m));
        }
        assertTrue(facade.getMembers().equals(membersDTO));
    }
}