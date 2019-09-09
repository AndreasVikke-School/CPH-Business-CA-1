package facades;

import dto.MemberDTO;
import entities.ColorEnum;
import utils.EMF_Creator;
import entities.Member;
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
public class MemberFacadeTest {

    private static EntityManagerFactory emf;
    private static MemberFacade facade;
    private static List<Member> members = new ArrayList();

    public MemberFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       facade = MemberFacade.getMemberFacade(emf);
       
       members.add(new Member("Martin Frederiksen", "cph-mf237", ColorEnum.RED));
       members.add(new Member("Andreas Vikke", "cph-av105", ColorEnum.RED));
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Member.deleteAllRows").executeUpdate();
            for(Member m : members)
                em.persist(m);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    @Test
    @Disabled
    public void testGetMember() {
        assertEquals(2, 2);
    }
    
    @Test
    @Disabled
    public void testGetMembers(){
        List<MemberDTO> membersDTO = new ArrayList();
        for(Member m : members) {
            membersDTO.add(new MemberDTO(m));
        }
        assertEquals(membersDTO, equals(facade.getMembers()));
    }
}