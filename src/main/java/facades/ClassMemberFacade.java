package facades;

import dto.ClassMemberDTO;
import entities.ClassMember;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class ClassMemberFacade {

    private static ClassMemberFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private ClassMemberFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static ClassMemberFacade getClassMemberFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ClassMemberFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    

    public ClassMemberDTO getMember(long id) {
        return new ClassMemberDTO(getEntityManager().find(ClassMember.class, id));
    }

    public List<ClassMemberDTO> getMembers() {
        return getEntityManager().createQuery("SELECT new dto.ClassMemberDTO(cm) FROM ClassMember cm", ClassMemberDTO.class).getResultList();
    }

}
